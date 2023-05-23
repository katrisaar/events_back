package ee.valiit.events.business.events;

import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.business.eventuser.OrganizedEvent;
import ee.valiit.events.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/organizedevents")
    @Operation(summary = "Tagastab kõikide kasutaja poolt korraldatavate tulevaste (aktiivsete) ürituste nimekirja.",
                description = "Kui ühtegi vastavat üritust ei leita, siis tagastab vea")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi üritust", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<OrganizedEvent> findOrganizedEvents(@RequestParam Integer userId) {
        return eventsService.findOrganizedEvents(userId);
    }
}
