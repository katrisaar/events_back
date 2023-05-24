package ee.valiit.events.domain.eventuser;

import ee.valiit.events.business.eventuser.OrganizedEvent;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventUserMapper {


    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "event.name", target = "eventName")
    @Mapping(source = "event.time.registrationDate", target = "registrationDate")
    @Mapping(source = "event.time.startDate", target = "startDate")
    @Mapping(source = "event.spots.available", target = "spotsAvailable")
    @Mapping(source = "event.spots.taken", target = "spotsTaken")
    OrganizedEvent toOrganizedEvent(EventUser eventUser);

    List<OrganizedEvent> toOrganizedEvents(List<EventUser> eventUsers);

}