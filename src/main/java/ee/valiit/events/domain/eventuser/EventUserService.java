package ee.valiit.events.domain.eventuser;

import ee.valiit.events.business.enums.EventUserConnectionType;
import ee.valiit.events.business.enums.Status;
import ee.valiit.events.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventUserService {

    @Resource
    EventUserRepository eventUserRepository;

    public List<EventUser> findActiveOrganizedEventUsers(Integer userId) {
        List<EventUser> eventUsers = eventUserRepository.findAllActiveOrganizedEventUsersBy(userId, EventUserConnectionType.ORGANIZING.getTypeName(), Status.ACTIVE.getStatus());
        ValidationService.validateEventUserListExists(eventUsers);
        return eventUsers;
    }
}
