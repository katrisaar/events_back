package ee.valiit.events.business.events;

import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.business.events.dto.EventShorty;
import ee.valiit.events.business.eventuser.InterestedEvent;
import ee.valiit.events.business.eventuser.OrganisedEvent;
import ee.valiit.events.business.eventuser.ParticipatingEvent;
import ee.valiit.events.business.location.LocationDto;
import ee.valiit.events.business.events.dto.ExistingActivityTypes;
import ee.valiit.events.business.events.dto.EventInfo;
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
    EventsService eventsService;

    @GetMapping("/events/all")
    @Operation(summary = "Tagastab aktiivsete ürituste nimekirja.")
    public List<EventDto> getActiveEvents() {
        return eventsService.getActiveEvents();
    }

    @GetMapping("/location")
    @Operation(summary = "Tagastab frondi rippmenüü jaoks kõik olemasolevad piirkonnad.")
    public List<LocationDto> getLocations() {
        return eventsService.getLocations();
    }

    @PostMapping("/location")
    @Operation(summary = "Kasutaja poolt piirkonna lisamine",
            description = """
                    Loome süsteemi uue piirkonna. Tagastab selle uue piirkonna locationName ja locationId.
                    Kui lisatud piirkond on juba olemas, siis tagastame veatetate koodiga 333
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise nimega asukoht on nimekirjas juba olemas.", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public LocationDto addLocation(@RequestParam String newLocationName) {
        return eventsService.addLocation(newLocationName);
    }

    @GetMapping("/events/organised")
    @Operation(summary = "Tagastab userId alusel kõikide kasutaja poolt korraldatavate tulevaste (aktiivsete) ürituste nimekirja.",
            description = "Kui ühtegi vastavat üritust ei leita, siis tagastab vea 555")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi üritust", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<OrganisedEvent> findOrganisedEvents(@RequestParam Integer userId) {
        return eventsService.findOrganisedEvents(userId);
    }

    @GetMapping("/events/participating")
    @Operation(summary = "Tagastab userId alusel kõikide tulevaste (aktiivsete) ürituste nimekirja, kuhu kasutaja on osalejana registreerunud.",
            description = "Kui ühtegi vastavat üritust ei leita, siis tagastab vea 555")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi üritust", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<ParticipatingEvent> findParticipatingEvents(@RequestParam Integer userId) {
        return eventsService.findParticipatingEvents(userId);
    }

    @GetMapping("/events/interested")
    @Operation(summary = "Tagastab userId alusel kõikide tulevaste (aktiivsete) ürituste nimekirja, mille kasutaja on enda jaoks huvipakkuvaks märkinud.",
            description = "Kui ühtegi vastavat üritust ei leita, siis tagastab vea 555")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi üritust", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<InterestedEvent> findInterestedEvents(@RequestParam Integer userId) {
        return eventsService.findInterestedEvents(userId);
    }

    @GetMapping("/activitytype")
    @Operation(summary = "Leiab ja tagastab dropdowni olemasolevate tegevusvaldkondadega.")
    public List<ExistingActivityTypes> getActivityTypes() {
        List<ExistingActivityTypes> activityTypes = eventsService.getActivityTypes();
        return activityTypes;
    }

    @PostMapping("/activitytype")
    @Operation(summary = "Uue tegevusvaldkonna lisamine",
            description = """
                    Võimaldab olemasolevate hulka lisada uusi asjakohaseid tegevusvaldkondi.
                    Uue tegevusvaldkonna lisamisel kontrollitakse, kas lisatav variant on juhtumisi juba olemas.
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise nimega tegevusvaldkond on nimekirjas juba olemas.", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public ExistingActivityTypes addActivityType(@RequestParam String newActivityTypeName) {
        return eventsService.addActivityType(newActivityTypeName);
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
}
