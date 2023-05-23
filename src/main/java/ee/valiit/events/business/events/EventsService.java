package ee.valiit.events.business.events;

import ee.valiit.events.domain.activitytype.ActivityType;
import ee.valiit.events.domain.activitytype.ActivityTypeMapper;
import ee.valiit.events.domain.activitytype.ActivityTypeService;
import ee.valiit.events.domain.activitytype.ExistingActivityTypes;
import ee.valiit.events.domain.event.EventDto;
import ee.valiit.events.domain.event.EventService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    @Resource
    EventService eventService;
    
    @Resource
    ActivityTypeService activityTypeService;

    @Resource
    private ActivityTypeMapper activityTypeMapper;

    public List<EventDto> getActiveEvents() {
        return eventService.findAllActiveEvents();
    }
    
    public List<ExistingActivityTypes> getActivityTypes() {
        List<ActivityType> activityTypes = activityTypeService.getActivityTypes();

        List<ExistingActivityTypes> dtos = activityTypeMapper.toDtos(activityTypes);
        
        return dtos;
    }

    public void addActivityType(String activityTypeName) {
    }
}
