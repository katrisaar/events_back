package ee.valiit.events.domain.eventuser;

import ee.valiit.events.business.eventuser.InterestedEvent;
import ee.valiit.events.business.eventuser.OrganisedEvent;
import ee.valiit.events.business.eventuser.ParticipatingEvent;
import ee.valiit.events.domain.event.Event;
import ee.valiit.events.domain.location.Location;
import ee.valiit.events.domain.spot.Spot;
import ee.valiit.events.domain.time.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-25T09:37:04+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
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
}
