package ee.valiit.events.business.events;

import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.business.eventuser.OrganizedEvent;
import ee.valiit.events.domain.event.EventMapper;
import ee.valiit.events.domain.event.EventService;
import ee.valiit.events.domain.eventuser.EventUser;
import ee.valiit.events.domain.eventuser.EventUserMapper;
import ee.valiit.events.domain.eventuser.EventUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    @Resource
    EventService eventService;

    @Resource
    EventUserService eventUserService;

    @Resource
    EventMapper eventMapper;
    @Resource
    EventUserMapper eventUserMapper;

    public List<EventDto> getActiveEvents() {

        return eventService.findAllActiveEvents();
    }

    public List<OrganizedEvent> findOrganizedEvents(Integer userId) {
        List<EventUser> eventUsers = eventUserService.findActiveOrganizedEventUsers(userId);
        return eventUserMapper.toOrganizedEvents(eventUsers);
    }
}
