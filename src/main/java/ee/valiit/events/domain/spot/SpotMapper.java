package ee.valiit.events.domain.spot;

import ee.valiit.events.business.events.dto.EventInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SpotMapper {
    @Mapping(source = "spotsMax", target = "available")
    @Mapping(source = "spotsMax", target = "max")
    @Mapping(source = "spotsMin", target = "min")
    @Mapping(source = "spotsTaken", target = "taken")
    Spot toSpot(EventInfo eventInfo);

}