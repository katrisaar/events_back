package ee.valiit.events.business.events;

import ee.valiit.events.domain.activitytype.ExistingActivityTypes;
import ee.valiit.events.domain.event.EventDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventsController {

    @Resource
    EventsService eventsService;

    @GetMapping("/events")
    @Operation(summary = "Tagastab aktiivsete ürituste nimekirja.")
    public List<EventDto> getActiveEvents() {
        return eventsService.getActiveEvents();
    }

    @GetMapping("/activitytypes")
    @Operation(summary = "Leiab ja tagastab dropdowni olemasolevate tegevusvaldkondadega.")
    public List<ExistingActivityTypes> getActivityTypes() {
        List<ExistingActivityTypes> activityTypes = eventsService.getActivityTypes();
        return activityTypes;
    }
}
