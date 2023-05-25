package ee.valiit.events.domain.spot;

import ee.valiit.events.domain.event.EventInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SpotMapper {
    @Mapping(source = "spotsAvailable", target = "available")
    @Mapping(source = "spotsMax", target = "max")
    @Mapping(source = "spotsMin", target = "min")
    @Mapping(source = "spotsTaken", target = "taken")
    Spot toSpot(EventInfo eventInfo);

}