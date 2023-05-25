package ee.valiit.events.domain.time;

import ee.valiit.events.domain.event.EventInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TimeMapper {

//    @Mapping(source = "startTime", target = "startTime")
//    @Mapping(source = "registrationDate", target = "registrationDate")
//    @Mapping(source = "startDate", target = "startDate")
//    @Mapping(source = "endTime", target = "endTime")
//    @Mapping(source = "endDate", target = "endDate")
    Time toTime(EventInfo eventInfo);

}