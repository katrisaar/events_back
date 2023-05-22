package ee.valiit.events.domain.event;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {
    @Mapping(source = "time.startDate", target = "startDate")
    @Mapping(source = "time.registrationDate", target = "registrationDate")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "location.name", target = "locationName")
    @Mapping(source = "fee", target = "fee")
    @Mapping(source = "activityType.name", target = "activityTypeName")
    @Mapping(source = "spots.available", target = "spotsAvailable")
    EventDto toDto(Event event);

    List<EventDto> eventDtos(List<Event> events);

}