package ee.valiit.events.domain.time;

import ee.valiit.events.business.events.dto.EventInfo;
import ee.valiit.events.domain.util.TimeUtil;
import org.mapstruct.*;

import java.time.LocalTime;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TimeMapper {

    @Mapping(source = "startTime", target = "startTime", qualifiedByName = "getLocalTimeFromString")
    @Mapping(source = "endTime", target = "endTime", qualifiedByName = "getLocalTimeFromString")
    Time toTime(EventInfo eventInfo);

    @Mapping(source = "startTime", target = "startTime", qualifiedByName = "getLocalTimeFromString")
    @Mapping(source = "endTime", target = "endTime", qualifiedByName = "getLocalTimeFromString")
    Time partialTimeUpdate(EventInfo eventInfo, @MappingTarget Time time);

    @Named("getLocalTimeFromString")
    static LocalTime getLocalTimeFromString(String timeString) {
        return TimeUtil.getLocalTimeFromString(timeString);
    }
}