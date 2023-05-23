package ee.valiit.events.domain.event;

import ee.valiit.events.business.Status;
import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.domain.location.Location;
import ee.valiit.events.domain.location.LocationRepository;
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
}
