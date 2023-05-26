package ee.valiit.events.domain.time;

import ee.valiit.events.domain.event.EventInfo;
import ee.valiit.events.domain.util.TimeUtil;
import org.mapstruct.*;

import java.time.LocalTime;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TimeMapper {

//    @Mapping(source = "startTime", target = "startTime")
//    @Mapping(source = "registrationDate", target = "registrationDate")
//    @Mapping(source = "startDate", target = "startDate")
//    @Mapping(source = "endTime", target = "endTime")
//    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "startTime", target = "startTime", qualifiedByName = "getLocalTimeFromString")
    @Mapping(source = "endTime", target = "endTime", qualifiedByName = "getLocalTimeFromString")
    Time toTime(EventInfo eventInfo);


    @Named("getLocalTimeFromString")
    static LocalTime getLocalTimeFromString(String timeString) {
        return TimeUtil.getLocalTimeFromString(timeString);
    }

}