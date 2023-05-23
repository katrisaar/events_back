package ee.valiit.events.domain.activitytype;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActivityTypeMapper {

    @Mapping(source = "id", target = "activityTypeId")
    @Mapping(source = "name", target = "activityTypeName")
    ExistingActivityTypes toDto(ActivityType activityType);

    List<ExistingActivityTypes> toDtos(List<ActivityType> activityTypes);
}