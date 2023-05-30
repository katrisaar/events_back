package ee.valiit.events.business.connection;

import ee.valiit.events.business.connection.dto.*;
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
public class ConnectionController {
    @Resource
    ConnectionService connectionService;

    @GetMapping("/events/organised")
    @Operation(summary = "Tagastab userId alusel kõikide kasutaja poolt korraldatavate tulevaste (aktiivsete ja täitunud) ürituste nimekirja.",
            description = "Tagastab ka tühistatud üritused, mille planeeritud toimumisaeg pole veel läbi. Kui ühtegi üritust ei leita, siis tagastab vea 555")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi üritust", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<OrganisedEvent> findOrganisedEvents(@RequestParam Integer userId) {
        return connectionService.findOrganisedEvents(userId);
    }

    @GetMapping("/events/participating")
    @Operation(summary = "Tagastab userId alusel kõikide tulevaste (aktiivsete) ürituste nimekirja, kuhu kasutaja on osalejana registreerunud.",
            description = "Kui ühtegi vastavat üritust ei leita, siis tagastab vea 555")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi üritust", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<ParticipatingEvent> findParticipatingEvents(@RequestParam Integer userId) {
        return connectionService.findParticipatingEvents(userId);
    }

    @GetMapping("/events/interested")
    @Operation(summary = "Tagastab userId alusel kõikide tulevaste (aktiivsete) ürituste nimekirja, mille kasutaja on enda jaoks huvipakkuvaks märkinud.",
            description = "Kui ühtegi vastavat üritust ei leita, siis tagastab vea 555")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi üritust", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<InterestedEvent> findInterestedEvents(@RequestParam Integer userId) {
        return connectionService.findInterestedEvents(userId);
    }

    @GetMapping("/events/history")
    @Operation(summary = "Tagastab userId alusel kõikide toimunud ürituste nimekirja, mida kasutaja on korraldanud või kus ta on osalenud",
            description = "Kui ühtegi vastavat üritust ei leita, siis tagastab vea 555")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi üritust", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<HistoryEvent> findHistoryEvents(@RequestParam Integer userId) {
        return connectionService.findHistoryEvents(userId);
    }

    @GetMapping("/connection/organisers")
    @Operation(summary = "Toob eventId alusel ära kõik selle ürituse korraldajad")
    public List<EventUserProfileName> getOrganisers(@RequestParam Integer eventId) {
        return connectionService.getOrganisers(eventId);
    }

    @GetMapping("/connection/participants")
    @Operation(summary = "Toob eventId alusel ära kõik sellel üritusel osalejad.",
            description = "Kui ühtegi osalejat ei leita, siis tagastab vea 666")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi osalejat", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<EventUserProfileName> getParticipants(@RequestParam Integer eventId) {
        return connectionService.getParticipants(eventId);
    }

    @GetMapping("/connection/type")
    @Operation(summary = "Tagastab userId ja eventId alusel kasutaja seoseliigi antud sündmusega. Kui seost ei ole, siis tagastab liigiks 'none'.")
    public ConnectionTypeName getUserConnectionToEvent(@RequestParam Integer eventId, @RequestParam Integer userId) {
        return connectionService.getUserConnectionToEvent(eventId, userId);
    }

    @PostMapping("/connection/participant")
    @Operation(summary = "Määrab kasutaja üritusel osalejaks etteantud userId ja eventId alusel.")
    public void addParticipant(@RequestParam Integer eventId, @RequestParam Integer userId) {
        connectionService.addParticipant(eventId, userId);
    }

    @PostMapping("/connection/organiser")
    @Operation(summary = "Lisab üritusele uue korraldaja sissetulnud kasutajanime ja eventId alusel.",
            description = "Kui sellise kasutajanimega aktiivset kasutajat süsteemis ei ole, siis tagastab vea 224.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei ole sellise kasutajanimega kasutajat", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addOrganiser(@RequestParam Integer eventId, @RequestParam String username) {
        connectionService.addOrganiser(eventId, username);
    }

    @DeleteMapping("/connection/participant")
    @Operation (summary = "Kustutab osaleja tüüpi seose kasutaja ja ürituse vahel etteantud userId ja eventId alusel.")
    public void deleteParticipant(@RequestParam Integer eventId, @RequestParam Integer userId) {
        connectionService.deleteParticipant(eventId, userId);
    }

    @PostMapping("connection/interested")
    @Operation(summary = "Võimaldab etteantud UserId ja eventId alusel määrata, et kasutaja on üritusest huvitatud")
    public void addInterested(@RequestParam Integer eventId, @RequestParam Integer userId) {
        connectionService.addInterested(eventId, userId);
    }

}
