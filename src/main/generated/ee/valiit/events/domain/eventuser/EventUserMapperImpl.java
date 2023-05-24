package ee.valiit.events.domain.eventuser;

import ee.valiit.events.business.eventuser.OrganizedEvent;
import ee.valiit.events.domain.event.Event;
import ee.valiit.events.domain.spot.Spot;
import ee.valiit.events.domain.time.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-24T13:50:26+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class EventUserMapperImpl implements EventUserMapper {

    @Override
    public OrganizedEvent toOrganizedEvent(EventUser eventUser) {
        if ( eventUser == null ) {
            return null;
        }

        OrganizedEvent organizedEvent = new OrganizedEvent();

        organizedEvent.setEventId( eventUserEventId( eventUser ) );
        organizedEvent.setEventName( eventUserEventName( eventUser ) );
        organizedEvent.setRegistrationDate( eventUserEventTimeRegistrationDate( eventUser ) );
        organizedEvent.setStartDate( eventUserEventTimeStartDate( eventUser ) );
        organizedEvent.setSpotsAvailable( eventUserEventSpotsAvailable( eventUser ) );
        organizedEvent.setSpotsTaken( eventUserEventSpotsTaken( eventUser ) );

        return organizedEvent;
    }

    @Override
    public List<OrganizedEvent> toOrganizedEvents(List<EventUser> eventUsers) {
        if ( eventUsers == null ) {
            return null;
        }

        List<OrganizedEvent> list = new ArrayList<OrganizedEvent>( eventUsers.size() );
        for ( EventUser eventUser : eventUsers ) {
            list.add( toOrganizedEvent( eventUser ) );
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
}
