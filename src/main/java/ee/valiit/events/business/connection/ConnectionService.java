package ee.valiit.events.business.connection;

import ee.valiit.events.business.connection.dto.*;
import ee.valiit.events.business.enums.EventUserConnectionType;
import ee.valiit.events.business.enums.Status;
import ee.valiit.events.domain.connectiontype.ConnectionType;
import ee.valiit.events.domain.connectiontype.ConnectionTypeService;
import ee.valiit.events.domain.event.Event;
import ee.valiit.events.domain.event.EventService;
import ee.valiit.events.domain.eventuser.EventUser;
import ee.valiit.events.domain.eventuser.EventUserMapper;
import ee.valiit.events.domain.eventuser.EventUserService;
import ee.valiit.events.domain.spot.Spot;
import ee.valiit.events.domain.spot.SpotService;
import ee.valiit.events.domain.user.User;
import ee.valiit.events.domain.user.UserService;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ConnectionService {
    @Resource
    EventUserService eventUserService;
    @Resource
    EventService eventService;
    @Resource
    UserService userService;
    @Resource
    ConnectionTypeService connectionTypeService;
    @Resource
    SpotService spotService;
    @Resource
    EventUserMapper eventUserMapper;


    public List<OrganisedEvent> findOrganisedEvents(Integer userId) {
        List<EventUser> eventUsers = eventUserService.findActiveOrCancelledOrganisedEventUsers(userId);
        return eventUserMapper.toOrganisedEvents(eventUsers);
    }

    public List<ParticipatingEvent> findParticipatingEvents(Integer userId) {
        List<EventUser> eventUsers = eventUserService.findActiveOrCancelledParticipatingEventUsers(userId);
        return eventUserMapper.toParticipatingEvents(eventUsers);
    }

    public List<InterestedEvent> findInterestedEvents(Integer userId) {
        List<EventUser> eventUsers = eventUserService.findActiveInterestedEventUsers(userId);
        return eventUserMapper.toInterestedEvents(eventUsers);
    }


    public List<HistoryEvent> findHistoryEvents(Integer userId) {
        List<EventUser> eventUsers = eventUserService.findHistoryEventsBy(userId);
        return eventUserMapper.toHistoryEvents(eventUsers);
    }

    public List<EventUserProfileName> getOrganisers(Integer eventId) {
        List<EventUser> eventUsers = eventUserService.getActiveEventOrganisers(eventId);
        return eventUserMapper.toEventUserProfileNames(eventUsers);
    }

    public List<EventUserProfileName> getParticipants(Integer eventId) {
        List<EventUser> eventUsers = eventUserService.findActiveEventParticipants(eventId);
        return eventUserMapper.toEventUserProfileNames(eventUsers);
    }

    public ConnectionTypeName getUserConnectionToEvent(Integer eventId, Integer userId) {
        Optional<EventUser> connection = eventUserService.findActiveUserConnectionToEvent(eventId, userId);
        ConnectionTypeName connectionTypeName = new ConnectionTypeName();
        if (connection.isEmpty()) {
            connectionTypeName.setName(EventUserConnectionType.NONE.getTypeName());
        } else {
            connectionTypeName.setName(connection.get().getConnectionType().getName());
        }
        return connectionTypeName;
    }

    @Transactional
    public void addParticipant(Integer eventId, Integer userId) {
        Optional<EventUser> eventUserOptional = eventUserService.updateExistingActiveConnectionToParticipateIfExists(eventId, userId);
        Event event = eventService.getEventBy(eventId);
        ConnectionType connectionType = connectionTypeService.getConnectionTypeBy(EventUserConnectionType.PARTICIPATING.getTypeName());

        if (eventUserOptional.isPresent()) {
            EventUser eventUser = eventUserOptional.get();
            eventUser.setConnectionType(connectionType);
            eventUserService.update(eventUser);
        } else {
            User user = userService.getUserBy(userId);
            eventUserService.addConnection(event, user, connectionType);
        }
        Spot spot = event.getSpots();
        spot.setTaken(spot.getTaken() + 1);
        spot.setAvailable(spot.getAvailable() - 1);
        spotService.update(spot);
        if (spot.getAvailable() == 0) {
            event.setStatus(Status.FILLED.getStatus());
            eventService.updateEvent(event);
        }
    }

    public void addOrganiser(Integer eventId, String username) {
        User user = userService.findActiveUser(username);
        eventUserService.validateUserIsNotAlreadyEventOrganiser(user.getId(), eventId);
        eventUserService.deleteInterestedConnectionIfExists(eventId, user.getId());
        boolean participationConnectionExists = eventUserService.deleteParticipationConnectionIfExists(eventId, user.getId());
        Event event = eventService.getEventBy(eventId);
        ConnectionType connectionType = connectionTypeService.getConnectionTypeBy(EventUserConnectionType.ORGANIZING.getTypeName());
        eventUserService.addConnection(event, user, connectionType);
        if (participationConnectionExists) {
            Spot spot = event.getSpots();
            spot.setTaken(spot.getTaken()-1);
            spot.setAvailable(spot.getAvailable()+1);
            spotService.update(spot);
        }
    }

    @Transactional
    public void deleteParticipant(Integer eventId, Integer userId) {
        eventUserService.deleteParticipatingConnection(eventId, userId, EventUserConnectionType.PARTICIPATING.getTypeName());
        Event event = eventService.getEventBy(eventId);
        Spot spot = event.getSpots();
        spot.setTaken(spot.getTaken()-1);
        spot.setAvailable(spot.getAvailable()+1);
        spotService.update(spot);
        if (spot.getAvailable() == 1) {
            LocalDate registrationDate = event.getTime().getRegistrationDate();
            if (LocalDate.now().isBefore(registrationDate)) {
                event.setStatus(Status.ACTIVE.getStatus());
                eventService.updateEvent(event);
            }
        }
    }

    public void addInterested(Integer eventId, Integer userId) {
        Event event = eventService.getEventBy(eventId);
        User user = userService.getUserBy(userId);
        ConnectionType connectionType = connectionTypeService.getConnectionTypeBy(EventUserConnectionType.INTERESTED.getTypeName());
        eventUserService.addConnection(event, user, connectionType);
    }
}
