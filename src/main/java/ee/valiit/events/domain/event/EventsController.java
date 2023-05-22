package ee.valiit.events.domain.event;

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
}
