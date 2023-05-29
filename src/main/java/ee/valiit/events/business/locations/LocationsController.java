package ee.valiit.events.business.locations;

import ee.valiit.events.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationsController {

    @Resource
    LocationsService locationsService;

    @GetMapping("/location")
    @Operation(summary = "Tagastab frondi rippmenüü jaoks kõik olemasolevad piirkonnad.")
    public List<LocationDto> getLocations() {
        return locationsService.getLocations();
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
        return locationsService.addLocation(newLocationName);
    }
}
