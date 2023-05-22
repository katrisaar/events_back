package ee.valiit.events.domain.event;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    @Resource
    EventService eventService;

    public List<EventDto> getActiveEvents() {

        return eventService.findAllActiveEvents();
    }
}
