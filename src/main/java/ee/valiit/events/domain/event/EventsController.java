package ee.valiit.events.domain.event;

import ee.valiit.events.domain.location.LocationDto;
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

    @GetMapping("/createevent")
    @Operation(summary = "Tagastab frondi rippmenüü jaoks kõik olemasolevad piirkonnad.")
    public List<LocationDto> getLocations() {
        return eventsService.getLocations();
    }
}
