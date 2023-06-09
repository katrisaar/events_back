package ee.valiit.events.domain.activitytype;

import ee.valiit.events.business.activitytypes.ExistingActivityTypes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActivityTypeMapper {

    @Mapping(source = "id", target = "activityTypeId")
    @Mapping(source = "name", target = "activityTypeName")
    ExistingActivityTypes toActivityTypeDto(ActivityType activityType);

    List<ExistingActivityTypes> toDtos(List<ActivityType> activityTypes);
}