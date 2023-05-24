package ee.valiit.events.domain.event;

import ee.valiit.events.business.events.dto.EventDto;
import org.mapstruct.*;
import ee.valiit.events.business.events.dto.EventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {
    @Mapping(source = "time.startDate", target = "startDate")
    @Mapping(source = "id", target = "eventId")
    @Mapping(source = "time.registrationDate", target = "registrationDate")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "location.name", target = "locationName")
    @Mapping(source = "fee", target = "fee")
    @Mapping(source = "activityType.name", target = "activityTypeName")
    @Mapping(source = "spots.available", target = "spotsAvailable")
    EventDto toDto(Event event);

    List<EventDto> eventDtos(List<Event> events);


}