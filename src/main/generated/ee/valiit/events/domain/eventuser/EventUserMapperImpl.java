package ee.valiit.events.domain.eventuser;

import ee.valiit.events.business.connection.dto.EventUserProfileName;
import ee.valiit.events.business.connection.dto.HistoryEvent;
import ee.valiit.events.business.connection.dto.InterestedEvent;
import ee.valiit.events.business.connection.dto.OrganisedEvent;
import ee.valiit.events.business.connection.dto.ParticipatingEvent;
import ee.valiit.events.domain.connectiontype.ConnectionType;
import ee.valiit.events.domain.event.Event;
import ee.valiit.events.domain.location.Location;
import ee.valiit.events.domain.spot.Spot;
import ee.valiit.events.domain.time.Time;
import ee.valiit.events.domain.user.User;
import ee.valiit.events.domain.user.contact.Contact;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T06:52:18+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (JetBrains s.r.o.)"
)
@Component
public class EventUserMapperImpl implements EventUserMapper {

    @Override
    public OrganisedEvent toOrganisedEvent(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }

        OrganisedEvent organisedEvent = new OrganisedEvent();

        organisedEvent.setEventId( eventUserEventId( eventUser ) );
        organisedEvent.setEventName( eventUserEventName( eventUser ) );
        organisedEvent.setRegistrationDate( eventUserEventTimeRegistrationDate( eventUser ) );
        organisedEvent.setStartDate( eventUserEventTimeStartDate( eventUser ) );
        organisedEvent.setSpotsAvailable( eventUserEventSpotsAvailable( eventUser ) );
        organisedEvent.setSpotsTaken( eventUserEventSpotsTaken( eventUser ) );
        organisedEvent.setStatus( eventUser.getStatus() );

        return organisedEvent;
    }

    @Override
    public List<OrganisedEvent> toOrganisedEvents(List<EventUser> eventUsers) {
        if ( eventUsers == null ) {
            return null;
        }

        List<OrganisedEvent> list = new ArrayList<OrganisedEvent>( eventUsers.size() );
        for ( EventUser eventUser : eventUsers ) {
            list.add( toOrganisedEvent( eventUser ) );
        }

        return list;
    }

    @Override
    public ParticipatingEvent toParticipatingEvent(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }

        ParticipatingEvent participatingEvent = new ParticipatingEvent();

        participatingEvent.setEventId( eventUserEventId( eventUser ) );
        participatingEvent.setEventName( eventUserEventName( eventUser ) );
        participatingEvent.setStartDate( eventUserEventTimeStartDate( eventUser ) );
        participatingEvent.setLocationName( eventUserEventLocationName( eventUser ) );
        participatingEvent.setFee( eventUserEventFee( eventUser ) );
        participatingEvent.setStatus( eventUser.getStatus() );

        return participatingEvent;
    }

    @Override
    public List<ParticipatingEvent> toParticipatingEvents(List<EventUser> eventUsers) {
        if ( eventUsers == null ) {
            return null;
        }

        List<ParticipatingEvent> list = new ArrayList<ParticipatingEvent>( eventUsers.size() );
        for ( EventUser eventUser : eventUsers ) {
            list.add( toParticipatingEvent( eventUser ) );
        }

        return list;
    }

    @Override
    public InterestedEvent toInterestedEvent(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }

        InterestedEvent interestedEvent = new InterestedEvent();

        interestedEvent.setEventId( eventUserEventId( eventUser ) );
        interestedEvent.setEventName( eventUserEventName( eventUser ) );
        interestedEvent.setStartDate( eventUserEventTimeStartDate( eventUser ) );
        interestedEvent.setRegistrationDate( eventUserEventTimeRegistrationDate( eventUser ) );
        interestedEvent.setLocationName( eventUserEventLocationName( eventUser ) );
        interestedEvent.setSpotsAvailable( eventUserEventSpotsAvailable( eventUser ) );

        return interestedEvent;
    }

    @Override
    public List<InterestedEvent> toInterestedEvents(List<EventUser> eventUsers) {
        if ( eventUsers == null ) {
            return null;
        }

        List<InterestedEvent> list = new ArrayList<InterestedEvent>( eventUsers.size() );
        for ( EventUser eventUser : eventUsers ) {
            list.add( toInterestedEvent( eventUser ) );
        }

        return list;
    }

    @Override
    public EventUserProfileName toEventUserProfileNames(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }

        EventUserProfileName eventUserProfileName = new EventUserProfileName();

        eventUserProfileName.setFirstName( eventUserUserContactFirstName( eventUser ) );
        eventUserProfileName.setLastName( eventUserUserContactLastName( eventUser ) );

        return eventUserProfileName;
    }

    @Override
    public List<EventUserProfileName> toEventUserProfileNames(List<EventUser> eventUsers) {
        if ( eventUsers == null ) {
            return null;
        }

        List<EventUserProfileName> list = new ArrayList<EventUserProfileName>( eventUsers.size() );
        for ( EventUser eventUser : eventUsers ) {
            list.add( toEventUserProfileNames( eventUser ) );
        }

        return list;
    }

    @Override
    public HistoryEvent toHistoryEvent(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }

        HistoryEvent historyEvent = new HistoryEvent();

        historyEvent.setEventId( eventUserEventId( eventUser ) );
        historyEvent.setEventName( eventUserEventName( eventUser ) );
        historyEvent.setStartDate( eventUserEventTimeStartDate( eventUser ) );
        historyEvent.setLocationName( eventUserEventLocationName( eventUser ) );
        historyEvent.setSpotsTaken( eventUserEventSpotsTaken( eventUser ) );
        historyEvent.setConnectionTypeName( eventUserConnectionTypeName( eventUser ) );

        return historyEvent;
    }

    @Override
    public List<HistoryEvent> toHistoryEvents(List<EventUser> eventUsers) {
        if ( eventUsers == null ) {
            return null;
        }

        List<HistoryEvent> list = new ArrayList<HistoryEvent>( eventUsers.size() );
        for ( EventUser eventUser : eventUsers ) {
            list.add( toHistoryEvent( eventUser ) );
        }

        return list;
    }

    private Integer eventUserEventId(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }
        Event event = eventUser.getEvent();
        if ( event == null ) {
            return null;
        }
        Integer id = event.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String eventUserEventName(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }
        Event event = eventUser.getEvent();
        if ( event == null ) {
            return null;
        }
        String name = event.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private LocalDate eventUserEventTimeRegistrationDate(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }
        Event event = eventUser.getEvent();
        if ( event == null ) {
            return null;
        }
        Time time = event.getTime();
        if ( time == null ) {
            return null;
        }
        LocalDate registrationDate = time.getRegistrationDate();
        if ( registrationDate == null ) {
            return null;
        }
        return registrationDate;
    }

    private LocalDate eventUserEventTimeStartDate(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }
        Event event = eventUser.getEvent();
        if ( event == null ) {
            return null;
        }
        Time time = event.getTime();
        if ( time == null ) {
            return null;
        }
        LocalDate startDate = time.getStartDate();
        if ( startDate == null ) {
            return null;
        }
        return startDate;
    }

    private Integer eventUserEventSpotsAvailable(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }
        Event event = eventUser.getEvent();
        if ( event == null ) {
            return null;
        }
        Spot spots = event.getSpots();
        if ( spots == null ) {
            return null;
        }
        Integer available = spots.getAvailable();
        if ( available == null ) {
            return null;
        }
        return available;
    }

    private Integer eventUserEventSpotsTaken(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }
        Event event = eventUser.getEvent();
        if ( event == null ) {
            return null;
        }
        Spot spots = event.getSpots();
        if ( spots == null ) {
            return null;
        }
        Integer taken = spots.getTaken();
        if ( taken == null ) {
            return null;
        }
        return taken;
    }

    private String eventUserEventLocationName(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }
        Event event = eventUser.getEvent();
        if ( event == null ) {
            return null;
        }
        Location location = event.getLocation();
        if ( location == null ) {
            return null;
        }
        String name = location.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Integer eventUserEventFee(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }
        Event event = eventUser.getEvent();
        if ( event == null ) {
            return null;
        }
        Integer fee = event.getFee();
        if ( fee == null ) {
            return null;
        }
        return fee;
    }

    private String eventUserUserContactFirstName(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }
        User user = eventUser.getUser();
        if ( user == null ) {
            return null;
        }
        Contact contact = user.getContact();
        if ( contact == null ) {
            return null;
        }
        String firstName = contact.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String eventUserUserContactLastName(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }
        User user = eventUser.getUser();
        if ( user == null ) {
            return null;
        }
        Contact contact = user.getContact();
        if ( contact == null ) {
            return null;
        }
        String lastName = contact.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String eventUserConnectionTypeName(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }
        ConnectionType connectionType = eventUser.getConnectionType();
        if ( connectionType == null ) {
            return null;
        }
        String name = connectionType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
