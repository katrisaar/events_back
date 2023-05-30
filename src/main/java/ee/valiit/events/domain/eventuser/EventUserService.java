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

    public List<EventUser> findActiveOrCancelledOrganisedEventUsers(Integer userId) {
        List<EventUser> eventUsers = eventUserRepository.findAllActiveOrCancelledOrganisedEventUsersBy(userId, EventUserConnectionType.ORGANIZING.getTypeName(),
                Status.ACTIVE.getStatus(), Status.CANCELLED.getStatus());
        ValidationService.validateEventUserListExists(eventUsers);
        return eventUsers;
    }

    public List<EventUser> findActiveOrCancelledParticipatingEventUsers(Integer userId) {
        List<EventUser> eventUsers = eventUserRepository.findAllActiveOrCancelledParticipatingEventUsersBy(userId, EventUserConnectionType.PARTICIPATING.getTypeName(),
                Status.ACTIVE.getStatus(), Status.CANCELLED.getStatus());
        ValidationService.validateEventUserListExists(eventUsers);
        return eventUsers;
    }

    public List<EventUser> findActiveInterestedEventUsers(Integer userId) {
        List<EventUser> eventUsers = eventUserRepository.findAllActiveInterestedEventUsersBy(userId, EventUserConnectionType.INTERESTED.getTypeName(), Status.ACTIVE.getStatus());
        ValidationService.validateEventUserListExists(eventUsers);
        return eventUsers;
    }


    public List<EventUser> findHistoryEventsBy(Integer userId) {
        List<EventUser> eventUsers = eventUserRepository.findHistoryEventsBy(userId, Status.HISTORY.getStatus());
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
        Optional<EventUser> connection = eventUserRepository.findSpecifiedStatusUserConnectionToEventBy(eventId, userId, Status.ACTIVE.getStatus());
        return connection;

    }

    public void replaceInterestedConnectionIfExists(Integer eventId, Integer userId, ConnectionType organiserConnectionType) {
        Optional<EventUser> interestedConnection = eventUserRepository.findActiveConnectionBy(eventId, userId, EventUserConnectionType.INTERESTED.getTypeName(), Status.ACTIVE.getStatus());
        if (interestedConnection.isPresent()) {
            EventUser eventUser = interestedConnection.get();
            eventUser.setConnectionType(organiserConnectionType);
            eventUserRepository.save(eventUser);
        }
    }

    public void addConnection(Event event, User user, ConnectionType connectionType) {
        EventUser eventUser = new EventUser();
        eventUser.setEvent(event);
        eventUser.setUser(user);
        eventUser.setConnectionType(connectionType);
        eventUser.setStatus(Status.ACTIVE.getStatus());
        eventUserRepository.save(eventUser);
    }

    public boolean replaceParticipationConnectionIfExists(Integer eventId, Integer userId, ConnectionType organiserConnectionType) {
        Optional<EventUser> participatingConnection = eventUserRepository.findActiveConnectionBy(eventId, userId, EventUserConnectionType.PARTICIPATING.getTypeName(), Status.ACTIVE.getStatus());
        if (participatingConnection.isPresent()) {
            EventUser eventUser = participatingConnection.get();
            eventUser.setConnectionType(organiserConnectionType);
            eventUserRepository.save(eventUser);
        }
        return participatingConnection.isPresent();
    }

    public void validateUserIsNotAlreadyEventOrganiser(Integer userId, Integer eventId) {
        Optional<EventUser> eventUserOptional = eventUserRepository.findActiveConnectionBy(eventId, userId, EventUserConnectionType.ORGANIZING.getTypeName(), Status.ACTIVE.getStatus());
        ValidationService.validateUserAlreadyIsEventOrganiser(eventUserOptional);
    }

    public void deleteDefinedTypeConnection(Integer eventId, Integer userId, String connectionType) {
        Optional<EventUser> optionalEventUser = eventUserRepository.findActiveConnectionBy(eventId, userId, connectionType, Status.ACTIVE.getStatus());
        EventUser eventUser = optionalEventUser.get();
        eventUserRepository.delete(eventUser);
    }

    public void cancelAllActiveEventConnectionsToUsersBy(Integer eventId) {
        List<EventUser> eventConnections = eventUserRepository.findAllSpecifiedStatusEventConnectionsBy(eventId, Status.ACTIVE.getStatus());
        for (EventUser eventConnection : eventConnections) {
            eventConnection.setStatus(Status.CANCELLED.getStatus());
        }
        eventUserRepository.saveAll(eventConnections);
    }

    public void deleteAllActiveEventConnectionsToUsersBy(Integer eventId) {
        List<EventUser> eventConnections = eventUserRepository.findAllSpecifiedStatusEventConnectionsBy(eventId, Status.ACTIVE.getStatus());
        for (EventUser eventConnection : eventConnections) {
            eventConnection.setStatus(Status.DELETED.getStatus());
        }
        eventUserRepository.saveAll(eventConnections);
    }

    public void updateStatusOfRelatedActiveConnectionsToHistoryBy(Integer eventId) {
        List<EventUser> eventConnections = eventUserRepository.findAllSpecifiedStatusEventConnectionsBy(eventId, Status.ACTIVE.getStatus());
        for (EventUser eventConnection : eventConnections) {
            eventConnection.setStatus(Status.HISTORY.getStatus());
        }
        eventUserRepository.saveAll(eventConnections);
    }

    public void deleteRelatedCancelledConnectionsBy(Integer eventId) {
        List<EventUser> eventConnections = eventUserRepository.findAllSpecifiedStatusEventConnectionsBy(eventId, Status.CANCELLED.getStatus());
        eventUserRepository.deleteAll(eventConnections);
    }

    public Optional<EventUser> updateExistingActiveConnectionToParticipateIfExists(Integer eventId, Integer userId) {
        return eventUserRepository.findSpecifiedStatusUserConnectionToEventBy(eventId, userId, Status.ACTIVE.getStatus());
        }

    public void update(EventUser eventUser) {
        eventUserRepository.save(eventUser);
    }

    public boolean newConnectionIsNeeded(Integer eventId, Integer userId) {
        return !eventUserRepository.activeConnectionExists(eventId, userId, Status.ACTIVE.getStatus());
    }
}
