package ee.valiit.events.domain.activitytype;

import ee.valiit.events.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeService {
    @Resource
    private ActivityTypeRepository activityTypeRepository;

    public List<ActivityType> getActivityTypes() {
        List<ActivityType> activityTypes = activityTypeRepository.findAll();
        return activityTypes;
    }

    public ActivityType getActivityType(Integer activityTypeId) {
        ActivityType activityType = activityTypeRepository.findById(activityTypeId).get();
        return activityType;
    }

    public void validateActivityTypeIsAvailableBy(String activityTypeName) {
        boolean activityTypeExists = activityTypeRepository.activityTypeExistsBy(activityTypeName);
        ValidationService.validateActivityTypeAlreadyExists(activityTypeExists);
    }

    public void addActivityType(ActivityType activityType) {
        activityTypeRepository.save(activityType);
    }

    public ActivityType getActivityTypeBy(String activityTypeName) {
        return activityTypeRepository.findActivityTypeBy(activityTypeName);
    }
}
