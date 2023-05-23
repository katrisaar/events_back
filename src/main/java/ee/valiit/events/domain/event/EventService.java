package ee.valiit.events.domain.event;

import ee.valiit.events.business.enums.Status;
import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.domain.eventuser.EventUser;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Resource
    EventRepository eventRepository;

    @Resource
    EventMapper eventMapper;


    public List<EventDto> findAllActiveEvents() {
        List<Event> activeEvents = eventRepository.findActiveEventsBy(Status.ACTIVE.getStatus());
        return eventMapper.eventDtos(activeEvents);
    }

}
