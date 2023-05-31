package ee.valiit.events.business.activitytypes;

import ee.valiit.events.domain.activitytype.ActivityType;
import ee.valiit.events.domain.activitytype.ActivityTypeMapper;
import ee.valiit.events.domain.activitytype.ActivityTypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypesService {
    @Resource
    ActivityTypeService activityTypeService;

    @Resource
    ActivityTypeMapper activityTypeMapper;

    public List<ExistingActivityTypes> getActivityTypes() {
        List<ActivityType> activityTypes = activityTypeService.getActivityTypes();
        List<ExistingActivityTypes> existingActivityTypes = activityTypeMapper.toDtos(activityTypes);
        return existingActivityTypes;
    }

    public ExistingActivityTypes addActivityType(String activityTypeName) {
        activityTypeService.validateActivityTypeIsAvailableBy(activityTypeName);
        ActivityType activityType = new ActivityType(activityTypeName);
        activityTypeService.addActivityType(activityType);
        return activityTypeMapper.toActivityTypeDto(activityType);
    }
}
