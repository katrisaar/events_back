package ee.valiit.events.business.events;

import ee.valiit.events.business.enums.EventUserConnectionType;
import ee.valiit.events.business.events.dto.EventSimple;
import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.business.events.dto.EventShorty;
import ee.valiit.events.business.eventuser.*;
import ee.valiit.events.business.location.LocationDto;
import ee.valiit.events.domain.address.Address;
import ee.valiit.events.domain.address.AddressMapper;
import ee.valiit.events.domain.address.AddressService;
import ee.valiit.events.domain.connectiontype.ConnectionType;
import ee.valiit.events.domain.connectiontype.ConnectionTypeService;
import ee.valiit.events.domain.event.Event;
import ee.valiit.events.business.events.dto.EventInfo;
import ee.valiit.events.domain.event.EventMapper;
import ee.valiit.events.domain.event.EventService;
import ee.valiit.events.domain.eventuser.EventUser;
import ee.valiit.events.domain.eventuser.EventUserMapper;
import ee.valiit.events.domain.eventuser.EventUserService;
import ee.valiit.events.domain.activitytype.ActivityType;
import ee.valiit.events.domain.activitytype.ActivityTypeMapper;
import ee.valiit.events.domain.activitytype.ActivityTypeService;
import ee.valiit.events.business.events.dto.ExistingActivityTypes;
import ee.valiit.events.domain.image.Image;
import ee.valiit.events.domain.image.ImageService;
import ee.valiit.events.domain.location.Location;
import ee.valiit.events.domain.location.LocationMapper;
import ee.valiit.events.domain.location.LocationService;
import ee.valiit.events.domain.spot.Spot;
import ee.valiit.events.domain.spot.SpotService;
import ee.valiit.events.domain.user.User;
import ee.valiit.events.domain.user.UserService;
import ee.valiit.events.domain.spot.SpotMapper;
import ee.valiit.events.domain.time.Time;
import ee.valiit.events.domain.time.TimeMapper;
import ee.valiit.events.domain.time.TimeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventsService {

    @Resource
    EventService eventService;

    @Resource
    LocationMapper locationMapper;

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
    EventMapper eventMapper;

    @Resource
    EventUserMapper eventUserMapper;

    @Resource
    ActivityTypeService activityTypeService;

    @Resource
    ActivityTypeMapper activityTypeMapper;

    @Resource
    TimeMapper timeMapper;
    @Resource
    TimeService timeService;
    @Resource
    AddressMapper addressMapper;
    @Resource
    AddressService addressService;
    @Resource
    SpotMapper spotMapper;
    @Resource
    ImageService imageService;

    public List<EventSimple> getActiveEvents(Integer userId) {
        List<EventSimple> allActiveEvents = eventService.findAllActiveEvents(userId);
        for (EventSimple event : allActiveEvents) {
            if (getUserConnectionToEvent(event.getEventId(), userId).getName().equals("none")) {
                event.setConnectionTypeName("");
            } else {
                event.setConnectionTypeName(getUserConnectionToEvent(event.getEventId(), userId).getName());
            }
        }
        return allActiveEvents;
    }

    public List<LocationDto> getLocations() {
        List<Location> allLocations = eventService.getAllLocations();
        return locationMapper.toLocationDtos(allLocations);
    }

    public LocationDto addLocation(String locationName) {
        locationService.validateLocationIsAvailableBy(locationName);
        Location location = new Location(locationName);
        locationService.addLocation(location);
        return locationMapper.toLocationDto(location);
    }

    public List<OrganisedEvent> findOrganisedEvents(Integer userId) {
        List<EventUser> eventUsers = eventUserService.findActiveOrganisedEventUsers(userId);
        return eventUserMapper.toOrganisedEvents(eventUsers);
    }

    public List<ParticipatingEvent> findParticipatingEvents(Integer userId) {
        List<EventUser> eventUsers = eventUserService.findActiveParticipatingEventUsers(userId);
        return eventUserMapper.toParticipatingEvents(eventUsers);
    }

    public List<InterestedEvent> findInterestedEvents(Integer userId) {
        List<EventUser> eventUsers = eventUserService.findActiveInterestedEventUsers(userId);
        return eventUserMapper.toInterestedEvents(eventUsers);
    }


    public List<HistoryEvent> findHistoryEvents(Integer userId) {
        List<EventUser> eventUsers = eventUserService.findHistoryEventsBy(userId);
        return eventUserMapper.toHistoryEvents(eventUsers);
    }

    public List<ExistingActivityTypes> getActivityTypes() {
        List<ActivityType> activityTypes = activityTypeService.getActivityTypes();
        List<ExistingActivityTypes> existingActivityTypes = activityTypeMapper.toDtos(activityTypes);
        return existingActivityTypes;
    }

    public ExistingActivityTypes addActivityType(String activityTypeName) {
        activityTypeService.validateActivityTypeIsAvailableBy(activityTypeName);
        ActivityType activityType = new ActivityType(activityTypeName);
        activityTypeService.addActivityType(activityType);
        return activityTypeMapper.toActivityTypeDto(activityType);
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

    public List<EventUserProfileName> getOrganisers(Integer eventId) {
        List<EventUser> eventUsers = eventUserService.getActiveEventOrganisers(eventId);
        return eventUserMapper.toEventUserProfileNames(eventUsers);
    }

    public List<EventUserProfileName> getParticipants(Integer eventId) {
        List<EventUser> eventUsers = eventUserService.findActiveEventParticipants(eventId);
        return eventUserMapper.toEventUserProfileNames(eventUsers);
    }

    public ConnectionTypeName getUserConnectionToEvent(Integer eventId, Integer userId) {
        Optional<EventUser> connection = eventUserService.findActiveUserConnectionToEvent(eventId, userId);
        ConnectionTypeName connectionTypeName = new ConnectionTypeName();
        if (connection.isEmpty()) {
            connectionTypeName.setName(EventUserConnectionType.NONE.getTypeName());
        } else {
            connectionTypeName.setName(connection.get().getConnectionType().getName());
        }
        return connectionTypeName;
    }

    @Transactional
    public void addParticipant(Integer eventId, Integer userId) {
        eventUserService.deleteInterestedConnectionIfExists(eventId, userId);
        Event event = eventService.getEventBy(eventId);
        User user = userService.getUserBy(userId);
        ConnectionType connectionType = connectionTypeService.getConnectionTypeBy(EventUserConnectionType.PARTICIPATING.getTypeName());
        eventUserService.addConnection(event, user, connectionType);
        Spot spot = event.getSpots();
        spot.setTaken(spot.getTaken() + 1);
        spot.setAvailable(spot.getAvailable() - 1);
        spotService.update(spot);
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

    public void addOrganiser(Integer eventId, String username) {
        User user = userService.findActiveUser(username);
        eventUserService.validateUserIsNotAlreadyEventOrganiser(user.getId(), eventId);
        eventUserService.deleteInterestedConnectionIfExists(eventId, user.getId());
        boolean participationConnectionExists = eventUserService.deleteParticipationConnectionIfExists(eventId, user.getId());
        Event event = eventService.getEventBy(eventId);
        ConnectionType connectionType = connectionTypeService.getConnectionTypeBy(EventUserConnectionType.ORGANIZING.getTypeName());
        eventUserService.addConnection(event, user, connectionType);
        if (participationConnectionExists) {
            Spot spot = event.getSpots();
            spot.setTaken(spot.getTaken()-1);
            spot.setAvailable(spot.getAvailable()+1);
            spotService.update(spot);
        }
    }

    @Transactional
    public void deleteParticipant(Integer eventId, Integer userId) {
        eventUserService.deleteParticipatingConnection(eventId, userId, EventUserConnectionType.PARTICIPATING.getTypeName());
        Event event = eventService.getEventBy(eventId);
        Spot spot = event.getSpots();
        spot.setTaken(spot.getTaken()-1);
        spot.setAvailable(spot.getAvailable()+1);
        spotService.update(spot);
        if (spot.getAvailable() == 1) {
            LocalDate registrationDate = event.getTime().getRegistrationDate();
            if (LocalDate.now().isBefore(registrationDate)) {
                event.setStatus(Status.ACTIVE.getStatus());
                eventService.updateEvent(event);
            }
        }
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
        eventService.updateEndedEventsStatusToHistory();
        eventService.updateCancelledEndedEventsStatusToDeleted();
    }

}
