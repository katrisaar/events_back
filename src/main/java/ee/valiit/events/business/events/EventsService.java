package ee.valiit.events.business.events;

import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.business.eventuser.InterestedEvent;
import ee.valiit.events.business.eventuser.OrganisedEvent;
import ee.valiit.events.business.eventuser.ParticipatingEvent;
import ee.valiit.events.business.location.LocationDto;
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
import ee.valiit.events.domain.location.Location;
import ee.valiit.events.domain.location.LocationMapper;
import ee.valiit.events.domain.location.LocationService;
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

        List<ExistingActivityTypes> dtos = activityTypeMapper.toDtos(activityTypes);

        return dtos;
    }

    public ExistingActivityTypes addActivityType(String activityTypeName) {
        activityTypeService.validateActivityTypeIsAvailableBy(activityTypeName);
        ActivityType activityType = new ActivityType(activityTypeName);
        activityTypeService.addActivityType(activityType);
        return activityTypeMapper.toActivityTypeDto(activityType);
    }
}
