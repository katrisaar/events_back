package ee.valiit.events.domain.activitytype;

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
}
