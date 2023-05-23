package ee.valiit.events.domain.event;

import ee.valiit.events.domain.location.Location;
import ee.valiit.events.domain.location.LocationDto;
import ee.valiit.events.domain.location.LocationMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    @Resource
    EventService eventService;
    @Resource
    LocationMapper locationMapper;

    public List<EventDto> getActiveEvents() {

        return eventService.findAllActiveEvents();
    }

    public List<LocationDto> getLocations() {
        List<Location> allLocations = eventService.getAllLocations();
        return locationMapper.toLocationDtos(allLocations);
    }
}
