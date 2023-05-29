package ee.valiit.events.business.activitytypes;

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
public class ActivityTypesController {
    @Resource
    ActivityTypesService activityTypesService;

    @GetMapping("/activitytype")
    @Operation(summary = "Leiab ja tagastab dropdowni olemasolevate tegevusvaldkondadega.")
    public List<ExistingActivityTypes> getActivityTypes() {
        return activityTypesService.getActivityTypes();
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
        return activityTypesService.addActivityType(newActivityTypeName);
    }
}
