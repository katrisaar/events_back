package ee.valiit.events.domain.event;

import ee.valiit.events.business.enums.Status;
import ee.valiit.events.business.events.dto.EventInfo;
import ee.valiit.events.business.events.dto.EventShorty;
import ee.valiit.events.business.events.dto.EventSimple;
import ee.valiit.events.domain.activitytype.ActivityType;
import ee.valiit.events.domain.address.Address;
import ee.valiit.events.domain.location.Location;
import ee.valiit.events.domain.spot.Spot;
import ee.valiit.events.domain.time.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-01T13:40:17+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public EventSimple toDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventSimple eventSimple = new EventSimple();

        eventSimple.setStartDate( eventTimeStartDate( event ) );
        eventSimple.setEventId( event.getId() );
        eventSimple.setRegistrationDate( eventTimeRegistrationDate( event ) );
        eventSimple.setName( event.getName() );
        eventSimple.setLocationName( eventLocationName( event ) );
        eventSimple.setFee( event.getFee() );
        eventSimple.setActivityTypeName( eventActivityTypeName( event ) );
        eventSimple.setSpotsAvailable( eventSpotsAvailable( event ) );

        return eventSimple;
    }

    @Override
    public List<EventSimple> eventDtos(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<EventSimple> list = new ArrayList<EventSimple>( events.size() );
        for ( Event event : events ) {
            list.add( toDto( event ) );
        }

        return list;
    }

    @Override
    public EventShorty toEventShorty(Event event) {
        if ( event == null ) {
            return null;
        }

        EventShorty eventShorty = new EventShorty();

        eventShorty.setEventId( event.getId() );
        eventShorty.setEventName( event.getName() );
        eventShorty.setLocationName( eventLocationName( event ) );
        eventShorty.setImageData( EventMapper.imageToImageData( event.getImage() ) );

        return eventShorty;
    }

    @Override
    public List<EventShorty> toEventShortys(List<Event> event) {
        if ( event == null ) {
            return null;
        }

        List<EventShorty> list = new ArrayList<EventShorty>( event.size() );
        for ( Event event1 : event ) {
            list.add( toEventShorty( event1 ) );
        }

        return list;
    }

    @Override
    public EventInfo toEventInfo(Event event) {
        if ( event == null ) {
            return null;
        }

        EventInfo eventInfo = new EventInfo();

        eventInfo.setEventName( event.getName() );
        eventInfo.setDescription( event.getDescription() );
        eventInfo.setImageData( EventMapper.imageToImageData( event.getImage() ) );
        eventInfo.setFee( event.getFee() );
        eventInfo.setLocationId( eventLocationId( event ) );
        eventInfo.setLocationName( eventLocationName( event ) );
        eventInfo.setActivityTypeId( eventActivityTypeId( event ) );
        eventInfo.setActivityTypeName( eventActivityTypeName( event ) );
        eventInfo.setRegistrationDate( eventTimeRegistrationDate( event ) );
        eventInfo.setStartDate( eventTimeStartDate( event ) );
        eventInfo.setStartTime( EventMapper.getStringFromLocalTime( eventTimeStartTime( event ) ) );
        eventInfo.setEndDate( eventTimeEndDate( event ) );
        eventInfo.setEndTime( EventMapper.getStringFromLocalTime( eventTimeEndTime( event ) ) );
        eventInfo.setAddressDescription( eventAddressDescription( event ) );
        eventInfo.setSpotsMin( eventSpotsMin( event ) );
        eventInfo.setSpotsMax( eventSpotsMax( event ) );
        eventInfo.setSpotsTaken( eventSpotsTaken( event ) );
        eventInfo.setSpotsAvailable( eventSpotsAvailable( event ) );

        return eventInfo;
    }

    @Override
    public Event toEvent(EventInfo eventInfo) {
        if ( eventInfo == null ) {
            return null;
        }

        Event event = new Event();

        event.setName( eventInfo.getEventName() );
        event.setDescription( eventInfo.getDescription() );
        event.setFee( eventInfo.getFee() );

        event.setStatus( Status.ACTIVE.getStatus() );

        return event;
    }

    @Override
    public Event partialUpdate(EventInfo eventInfo, Event event) {
        if ( eventInfo == null ) {
            return event;
        }

        event.setDescription( eventInfo.getDescription() );
        event.setFee( eventInfo.getFee() );
        event.setName( eventInfo.getEventName() );

        event.setStatus( Status.ACTIVE.getStatus() );

        return event;
    }

    private LocalDate eventTimeStartDate(Event event) {
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

    private LocalDate eventTimeRegistrationDate(Event event) {
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

    private String eventLocationName(Event event) {
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

    private String eventActivityTypeName(Event event) {
        if ( event == null ) {
            return null;
        }
        ActivityType activityType = event.getActivityType();
        if ( activityType == null ) {
            return null;
        }
        String name = activityType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Integer eventSpotsAvailable(Event event) {
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

    private Integer eventLocationId(Event event) {
        if ( event == null ) {
            return null;
        }
        Location location = event.getLocation();
        if ( location == null ) {
            return null;
        }
        Integer id = location.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer eventActivityTypeId(Event event) {
        if ( event == null ) {
            return null;
        }
        ActivityType activityType = event.getActivityType();
        if ( activityType == null ) {
            return null;
        }
        Integer id = activityType.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private LocalTime eventTimeStartTime(Event event) {
        if ( event == null ) {
            return null;
        }
        Time time = event.getTime();
        if ( time == null ) {
            return null;
        }
        LocalTime startTime = time.getStartTime();
        if ( startTime == null ) {
            return null;
        }
        return startTime;
    }

    private LocalDate eventTimeEndDate(Event event) {
        if ( event == null ) {
            return null;
        }
        Time time = event.getTime();
        if ( time == null ) {
            return null;
        }
        LocalDate endDate = time.getEndDate();
        if ( endDate == null ) {
            return null;
        }
        return endDate;
    }

    private LocalTime eventTimeEndTime(Event event) {
        if ( event == null ) {
            return null;
        }
        Time time = event.getTime();
        if ( time == null ) {
            return null;
        }
        LocalTime endTime = time.getEndTime();
        if ( endTime == null ) {
            return null;
        }
        return endTime;
    }

    private String eventAddressDescription(Event event) {
        if ( event == null ) {
            return null;
        }
        Address address = event.getAddress();
        if ( address == null ) {
            return null;
        }
        String description = address.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private Integer eventSpotsMin(Event event) {
        if ( event == null ) {
            return null;
        }
        Spot spots = event.getSpots();
        if ( spots == null ) {
            return null;
        }
        Integer min = spots.getMin();
        if ( min == null ) {
            return null;
        }
        return min;
    }

    private Integer eventSpotsMax(Event event) {
        if ( event == null ) {
            return null;
        }
        Spot spots = event.getSpots();
        if ( spots == null ) {
            return null;
        }
        Integer max = spots.getMax();
        if ( max == null ) {
            return null;
        }
        return max;
    }

    private Integer eventSpotsTaken(Event event) {
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
