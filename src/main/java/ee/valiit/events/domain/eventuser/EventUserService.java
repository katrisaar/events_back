package ee.valiit.events.domain.eventuser;

import ee.valiit.events.business.enums.EventUserConnectionType;
import ee.valiit.events.business.enums.Status;
import ee.valiit.events.domain.connectiontype.ConnectionType;
import ee.valiit.events.domain.event.Event;
import ee.valiit.events.domain.user.User;
import ee.valiit.events.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventUserService {

    @Resource
    EventUserRepository eventUserRepository;

    public List<EventUser> findActiveOrganisedEventUsers(Integer userId) {
        List<EventUser> eventUsers = eventUserRepository.findAllActiveOrganisedEventUsersBy(userId, EventUserConnectionType.ORGANIZING.getTypeName(), Status.ACTIVE.getStatus());
        ValidationService.validateEventUserListExists(eventUsers);
        return eventUsers;
    }

    public List<EventUser> findActiveParticipatingEventUsers(Integer userId) {
        List<EventUser> eventUsers = eventUserRepository.findAllActiveParticipatingEventUsersBy(userId, EventUserConnectionType.PARTICIPATING.getTypeName(), Status.ACTIVE.getStatus());
        ValidationService.validateEventUserListExists(eventUsers);
        return eventUsers;
    }

    public List<EventUser> findActiveInterestedEventUsers(Integer userId) {
        List<EventUser> eventUsers = eventUserRepository.findAllActiveInterestedEventUsersBy(userId, EventUserConnectionType.INTERESTED.getTypeName(), Status.ACTIVE.getStatus());
        ValidationService.validateEventUserListExists(eventUsers);
        return eventUsers;
    }

    public List<EventUser> getActiveEventOrganisers(Integer eventId) {
        return eventUserRepository.getActiveEventOrganisersBy(eventId, EventUserConnectionType.ORGANIZING.getTypeName(), Status.ACTIVE.getStatus());
    }

    public List<EventUser> findActiveEventParticipants(Integer eventId) {
        List<EventUser> eventUsers = eventUserRepository.findActiveEventParticipantsBy(eventId, EventUserConnectionType.PARTICIPATING.getTypeName(), Status.ACTIVE.getStatus());
        ValidationService.validateEventHasParticipants(eventUsers);
        return eventUsers;
    }

    public Optional<EventUser> findActiveUserConnectionToEvent(Integer eventId, Integer userId) {
        Optional<EventUser> connection = eventUserRepository.findActiveUserConnectionToEventBy(eventId, userId, Status.ACTIVE.getStatus());
        return connection;

    }

    public void deleteInterestedConnectionIfExists(Integer eventId, Integer userId) {
        Optional<EventUser> interestedConnection = eventUserRepository.findActiveInterestedConnectionBy(eventId, userId, EventUserConnectionType.INTERESTED.getTypeName(), Status.ACTIVE.getStatus());
        if (interestedConnection.isPresent()) {
            EventUser eventUser = interestedConnection.get();
            eventUser.setStatus(Status.DELETED.getStatus());
            eventUserRepository.save(eventUser);
        }
    }

    public void addParticipatingConnection(Event event, User user, ConnectionType connectionType) {
        EventUser eventUser = new EventUser();
        eventUser.setEvent(event);
        eventUser.setUser(user);
        eventUser.setConnectionType(connectionType);
        eventUser.setStatus(Status.ACTIVE.getStatus());
        eventUserRepository.save(eventUser);
    }
}
