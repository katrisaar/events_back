package ee.valiit.events.business.events;

import ee.valiit.events.business.events.dto.EventInfo;
import ee.valiit.events.business.events.dto.EventShorty;
import ee.valiit.events.business.events.dto.EventSimple;
import ee.valiit.events.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventsController {

    @Resource
    private EventsService eventsService;

    @GetMapping("/events/all")
    @Operation(summary = "Tagastab aktiivsete ürituste nimekirja.")
    public List<EventSimple> getActiveEvents(@RequestParam Integer userId) {
        return eventsService.getActiveEvents(userId);
    }

    @GetMapping("/events/soontoend")
    @Operation(summary = "Tagastab kolm üritust, mille registreerimise tähtaeg on kõige peatsemalt saabumas.",
            description = "Kui ühtegi vastavat üritust ei leita, siis tagastab vea 555")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi üritust", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<EventShorty> findSoonToEndEvents() {
        return eventsService.findSoonToEndEvents();
    }

    @GetMapping("/events/soontofill")
    @Operation(summary = "Tagastab kolm üritust, kus on kõige vähem vabasid kohti.",
            description = "Kui ühtegi vastavat üritust ei leita, siis tagastab vea 555")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi üritust", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<EventShorty> findSoonToFillEvents() {
        return eventsService.findSoonToFillEvents();
    }

    @GetMapping("/events/recent")
    @Operation(summary = "Tagastab kolm kõige viimasena loodud üritust.",
            description = "Kui ühtegi vastavat üritust ei leita, siis tagastab vea 555")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi üritust", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<EventShorty> findMostRecentEvents() {
        return eventsService.findMostRecentEvents();
    }

    @GetMapping("/event")
    @Operation(summary = "Tagastab eventId alusel vastava ürituse detailse informatsiooni")
    public EventInfo getEvent(@RequestParam Integer eventId) {
        return eventsService.getEvent(eventId);
    }

    @PostMapping("/event")
    @Operation(summary = "Uue ürituse lisamine.")
    public void addNewEvent(@RequestBody EventInfo eventInfo, @RequestParam Integer userId) {
        eventsService.addNewEvent(eventInfo, userId);
    }

    @PutMapping("/event")
    @Operation(summary = "Ürituse muutmine.")
    public void updateEvent(@RequestBody EventInfo eventInfo, @RequestParam Integer eventId) {
        eventsService.updateEvent(eventInfo, eventId);
    }

    @DeleteMapping("/event/cancel")
    @Operation(summary = "Tühistab etteantud eventId alusel ürituse ja sellega seotud osalused",
            description = "Tühistamiseks märgib staatuseks C ehk 'Cancelled'")
    public void cancelEvent(@RequestParam Integer eventId) {
        eventsService.cancelEvent(eventId);
    }

    @DeleteMapping("/event")
    @Operation(summary = "Kustutab andmebaasist etteantud eventId alusel ürituse ja sellega seotud osalused")
    public void deleteEvent(@RequestParam Integer eventId) {
        eventsService.deleteEvent(eventId);
    }

    @GetMapping("/events/statusupdate")
    @Operation(summary = "Administratiivne protsess,mis muudab kuupäeva järgi sündmuste staatust.",
            description = "Üritused, mille registreerumise kuupäev on läbi, muutuvad 'Filled'-iks, ehk neile ei saa enam registreeruda. Üritused, mis on ära toimunud (lõpukuupäev on läbi, või selle puudumisel alguskuupäev), muutuvad staatusesse 'History'")
    public void updateEventStatuses() {
        eventsService.updateEventStatuses();
    }

}
