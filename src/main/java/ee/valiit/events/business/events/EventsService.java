package ee.valiit.events.business.events;

import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.business.events.dto.EventShorty;
import ee.valiit.events.business.eventuser.InterestedEvent;
import ee.valiit.events.business.eventuser.OrganisedEvent;
import ee.valiit.events.business.eventuser.ParticipatingEvent;
import ee.valiit.events.business.location.LocationDto;
import ee.valiit.events.domain.address.Address;
import ee.valiit.events.domain.address.AddressMapper;
import ee.valiit.events.domain.address.AddressService;
import ee.valiit.events.domain.event.Event;
import ee.valiit.events.domain.event.EventInfo;
import ee.valiit.events.domain.event.EventMapper;
import ee.valiit.events.domain.event.EventService;
import ee.valiit.events.domain.eventuser.EventUser;
import ee.valiit.events.domain.eventuser.EventUserMapper;
import ee.valiit.events.domain.eventuser.EventUserService;
import ee.valiit.events.domain.activitytype.ActivityType;
import ee.valiit.events.domain.activitytype.ActivityTypeMapper;
import ee.valiit.events.domain.activitytype.ActivityTypeService;
import ee.valiit.events.domain.activitytype.ExistingActivityTypes;
import ee.valiit.events.domain.location.Location;
import ee.valiit.events.domain.location.LocationMapper;
import ee.valiit.events.domain.location.LocationService;
import ee.valiit.events.domain.spot.Spot;
import ee.valiit.events.domain.spot.SpotMapper;
import ee.valiit.events.domain.time.Time;
import ee.valiit.events.domain.time.TimeMapper;
import ee.valiit.events.domain.time.TimeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
    SpotService spotService;

    public List<EventDto> getActiveEvents() {

        return eventService.findAllActiveEvents();
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

    public void addNewEvent(EventInfo eventInfo, Integer userId) {
        ActivityType activityType = activityTypeService.getActivityTypeBy(eventInfo.getActivityTypeName());
        Location location = locationService.getLocationBy(eventInfo.getLocationName());
        Time time = timeMapper.toTime(eventInfo);
        timeService.addTime(time);
        Address address = addressMapper.toAddress(eventInfo);
        addressService.addAddress(address);
        Spot spot = spotMapper.toSpot(eventInfo);
        spotService.addSpot(spot);
        Event event = eventMapper.toEvent(eventInfo);
        event.setActivityType(activityType);
        event.setLocation(location);
        event.setTime(time);
        event.setAddress(address);
        event.setSpots(spot);
        eventService.addEvent(event);

    }
}
