package ee.valiit.events.domain.eventuser;

import ee.valiit.events.business.eventuser.InterestedEvent;
import ee.valiit.events.business.eventuser.OrganisedEvent;
import ee.valiit.events.business.eventuser.ParticipatingEvent;
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
    OrganisedEvent toOrganisedEvent(EventUser eventUser);

    List<OrganisedEvent> toOrganisedEvents(List<EventUser> eventUsers);

    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "event.name", target = "eventName")
    @Mapping(source = "event.time.startDate", target = "startDate")
    @Mapping(source = "event.location.name", target = "locationName")
    @Mapping(source = "event.fee", target = "fee")
    ParticipatingEvent toParticipatingEvent(EventUser eventUser);

    List<ParticipatingEvent> toParticipatingEvents(List<EventUser> eventUsers);

    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "event.name", target = "eventName")
    @Mapping(source = "event.time.startDate", target = "startDate")
    @Mapping(source = "event.time.registrationDate", target = "registrationDate")
    @Mapping(source = "event.location.name", target = "locationName")
    @Mapping(source = "event.spots.available", target = "spotsAvailable")
    InterestedEvent toInterestedEvent(EventUser eventUser);

    List<InterestedEvent> toInterestedEvents(List<EventUser> eventUsers);

}