package ee.valiit.events.domain.event;

import ee.valiit.events.business.enums.Status;
import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.domain.location.Location;
import ee.valiit.events.domain.location.LocationRepository;
import ee.valiit.events.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Resource
    EventRepository eventRepository;

    @Resource
    EventMapper eventMapper;
    @Resource
    LocationRepository locationRepository;


    public List<EventDto> findAllActiveEvents() {
        List<Event> activeEvents = eventRepository.findActiveEventsBy(Status.ACTIVE.getStatus());
        return eventMapper.eventDtos(activeEvents);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public List<Event> findSoonToEndEvents() {
        List<Event> events = eventRepository.findThreeActiveSoonToEndEventsBy(Status.ACTIVE.getStatus());
        ValidationService.validateEventListExists(events);
        return events;
    }

    public List<Event> findSoonToFillEvents() {
        List<Event> events = eventRepository.findThreeActiveSoonToFillEventsBy(Status.ACTIVE.getStatus());
        ValidationService.validateEventListExists(events);
        return events;
    }


    public List<Event> findMostRecentEvents() {
        List<Event> events = eventRepository.findThreeActiveMostRecentEventsBy(Status.ACTIVE.getStatus());
        ValidationService.validateEventListExists(events);
        return events;
    }

    public Event getEventBy(Integer eventId) {
        return eventRepository.findById(eventId).get();
    }
}
