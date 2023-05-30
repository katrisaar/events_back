package ee.valiit.events.business.events;

import ee.valiit.events.business.connection.ConnectionService;
import ee.valiit.events.business.enums.EventUserConnectionType;
import ee.valiit.events.business.enums.Status;
import ee.valiit.events.business.events.dto.EventInfo;
import ee.valiit.events.business.events.dto.EventShorty;
import ee.valiit.events.business.events.dto.EventSimple;
import ee.valiit.events.domain.activitytype.ActivityType;
import ee.valiit.events.domain.activitytype.ActivityTypeService;
import ee.valiit.events.domain.address.Address;
import ee.valiit.events.domain.address.AddressMapper;
import ee.valiit.events.domain.address.AddressService;
import ee.valiit.events.domain.connectiontype.ConnectionType;
import ee.valiit.events.domain.connectiontype.ConnectionTypeService;
import ee.valiit.events.domain.event.Event;
import ee.valiit.events.domain.event.EventMapper;
import ee.valiit.events.domain.event.EventService;
import ee.valiit.events.domain.eventuser.EventUserMapper;
import ee.valiit.events.domain.eventuser.EventUserService;
import ee.valiit.events.domain.image.Image;
import ee.valiit.events.domain.image.ImageService;
import ee.valiit.events.domain.location.Location;
import ee.valiit.events.domain.location.LocationService;
import ee.valiit.events.domain.spot.Spot;
import ee.valiit.events.domain.spot.SpotMapper;
import ee.valiit.events.domain.spot.SpotService;
import ee.valiit.events.domain.time.Time;
import ee.valiit.events.domain.time.TimeMapper;
import ee.valiit.events.domain.time.TimeService;
import ee.valiit.events.domain.user.User;
import ee.valiit.events.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventsService {

    @Resource
    EventService eventService;
    @Resource
    LocationService locationService;
    @Resource
    EventUserService eventUserService;
    @Resource
    UserService userService;
    @Resource
    ConnectionTypeService connectionTypeService;
    @Resource
    SpotService spotService;
    @Resource
    ConnectionService connectionService;
    @Resource
    ImageService imageService;
    @Resource
    ActivityTypeService activityTypeService;
    @Resource
    AddressService addressService;
    @Resource
    TimeService timeService;

    @Resource
    EventMapper eventMapper;
    @Resource
    EventUserMapper eventUserMapper;
    @Resource
    TimeMapper timeMapper;
    @Resource
    AddressMapper addressMapper;
    @Resource
    SpotMapper spotMapper;


    public List<EventSimple> getActiveEvents(Integer userId) {
        List<EventSimple> allActiveEvents = eventService.findAllActiveEvents(userId);
        for (EventSimple event : allActiveEvents) {
            if (connectionService.getUserConnectionToEvent(event.getEventId(), userId).getName().equals("none")) {
                event.setConnectionTypeName("");
            } else {
                event.setConnectionTypeName(connectionService.getUserConnectionToEvent(event.getEventId(), userId).getName());
            }
        }
        return allActiveEvents;
    }



    public List<EventShorty> findSoonToEndEvents() {
        List<Event> events = eventService.findSoonToEndEvents();
        return eventMapper.toEventShortys(events);
    }

    public List<EventShorty> findSoonToFillEvents() {
        List<Event> events = eventService.findSoonToFillEvents();
        return eventMapper.toEventShortys(events);
    }

    public List<EventShorty> findMostRecentEvents() {
        List<Event> events = eventService.findMostRecentEvents();
        return eventMapper.toEventShortys(events);
    }

    public EventInfo getEvent(Integer eventId) {
        Event event = eventService.getEventBy(eventId);
        return eventMapper.toEventInfo(event);
    }


    @Transactional
    public void addNewEvent(EventInfo eventInfo, Integer userId) {
        ActivityType activityType = activityTypeService.getActivityTypeBy(eventInfo.getActivityTypeId());
        Location location = locationService.getLocationBy(eventInfo.getLocationId());
        Time time = timeMapper.toTime(eventInfo);
        timeService.addTime(time);
        Address address = addressMapper.toAddress(eventInfo);
        addressService.addAddress(address);
        Spot spot = spotMapper.toSpot(eventInfo);
        spotService.addSpot(spot);
        Image image = imageService.addImage(eventInfo.getImageData());
        Event event = eventMapper.toEvent(eventInfo);
        event.setActivityType(activityType);
        event.setLocation(location);
        event.setTime(time);
        event.setAddress(address);
        event.setSpots(spot);
        event.setImage(image);
        eventService.addEvent(event);
        User user = userService.getUserBy(userId);
        ConnectionType connectionType = connectionTypeService.getConnectionTypeBy(EventUserConnectionType.ORGANIZING.getTypeName());
        eventUserService.addConnection(event, user, connectionType);

    }

    @Transactional
    public void cancelEvent(Integer eventId) {
        eventUserService.cancelAllActiveEventConnectionsToUsersBy(eventId);
        eventService.cancelEvent(eventId);
    }

    @Transactional
    public void deleteEvent(Integer eventId) {
        eventUserService.deleteAllActiveEventConnectionsToUsersBy(eventId);
        eventService.deleteEvent(eventId);
    }

    @Transactional
    public void updateEventStatuses() {
        eventService.updateRegistrationEndedEventsStatusToFilled();
        updateEndedActiveOrFilledEventsAndRelatedConnectionsStatusToHistory();
        updateCancelledEndedEventsAndRelatedConnectionsStatusToDeleted();
    }

    public void updateEndedActiveOrFilledEventsAndRelatedConnectionsStatusToHistory() {
        List<Event> endedActiveOrFilledEvents = eventService.findEndedActiveOrFilledEvents();
        for (Event endedEvent : endedActiveOrFilledEvents) {
            endedEvent.setStatus(Status.HISTORY.getStatus());
            eventService.updateEvent(endedEvent);
            eventUserService.updateStatusOfRelatedActiveConnectionsToHistoryBy(endedEvent.getId());
        }
    }

    public void updateCancelledEndedEventsAndRelatedConnectionsStatusToDeleted() {
        List<Event> endedCancelledEvents = eventService.findEndedCancelledEvents();
        for (Event endedEvent : endedCancelledEvents) {
            endedEvent.setStatus(Status.DELETED.getStatus());
            eventService.updateEvent(endedEvent);
            eventUserService.deleteRelatedCancelledConnectionsBy(endedEvent.getId());
        }
    }

}
