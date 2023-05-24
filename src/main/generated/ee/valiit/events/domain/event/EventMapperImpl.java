package ee.valiit.events.domain.event;

import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.domain.activitytype.ActivityType;
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
    date = "2023-05-24T13:50:26+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public EventDto toDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDto eventDto = new EventDto();

        eventDto.setStartDate( eventTimeStartDate( event ) );
        eventDto.setEventId( event.getId() );
        eventDto.setRegistrationDate( eventTimeRegistrationDate( event ) );
        eventDto.setName( event.getName() );
        eventDto.setLocationName( eventLocationName( event ) );
        eventDto.setFee( event.getFee() );
        eventDto.setActivityTypeName( eventActivityTypeName( event ) );
        eventDto.setSpotsAvailable( eventSpotsAvailable( event ) );

        return eventDto;
    }

    @Override
    public List<EventDto> eventDtos(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<EventDto> list = new ArrayList<EventDto>( events.size() );
        for ( Event event : events ) {
            list.add( toDto( event ) );
        }

        return list;
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
}
