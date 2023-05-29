package ee.valiit.events.domain.eventuser;

import ee.valiit.events.business.connection.dto.*;
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
    @Mapping(source = "status", target = "status")
    OrganisedEvent toOrganisedEvent(EventUser eventUser);

    List<OrganisedEvent> toOrganisedEvents(List<EventUser> eventUsers);

    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "event.name", target = "eventName")
    @Mapping(source = "event.time.startDate", target = "startDate")
    @Mapping(source = "event.location.name", target = "locationName")
    @Mapping(source = "event.fee", target = "fee")
    @Mapping(source = "status", target = "status")
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

    @Mapping(source = "user.contact.firstName", target = "firstName")
    @Mapping(source = "user.contact.lastName", target = "lastName")
    EventUserProfileName toEventUserProfileNames(EventUser eventUser);

    List<EventUserProfileName> toEventUserProfileNames(List<EventUser> eventUsers);

    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "event.name", target = "eventName")
    @Mapping(source = "event.time.startDate", target = "startDate")
    @Mapping(source = "event.location.name", target = "locationName")
    @Mapping(source = "event.spots.taken", target = "spotsTaken")
    @Mapping(source = "connectionType.name", target = "connectionTypeName")
    HistoryEvent toHistoryEvent(EventUser eventUser);

    List<HistoryEvent> toHistoryEvents(List<EventUser> eventUsers);
}