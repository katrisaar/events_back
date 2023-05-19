package ee.valiit.events.business.profile;

import ee.valiit.events.business.profile.dto.LoginResponse;
import ee.valiit.events.business.profile.dto.ProfileDetails;
import ee.valiit.events.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Resource
    private ProfileService profileService;

    @GetMapping("/login")
    @Operation(summary = "Sisse logimine. Tagastab userId ja roleName",
            description= """
                   Süsteemist otsitakse username ja password abil kasutajat, kelle konto on ka aktiivne. 
                   Kui vastet ei leita, visatakse viga errorCode'ga 111""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sorri, nõu kän du", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        return profileService.login(username, password);
    }

    @PostMapping("/profile")
    @Operation(summary = "Uue kasutaja loomine ja koheselt ka sisse logimine. Tagastab userId ja roleName",
            description= """
                   Loome süsteemi uue kasutaja ja logime ta ka kohe sisse.
                   Kui selgub, et soovitud kasutajanimi on sama, mis mõnel olemasoleval aktiivsel kasutajal, 
                   siis tagastame veatetate koodiga 222 
                   """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Kahju küll, aga soovitud kasutajanimi on juba hõivatud. Proovi midagi muud.", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public LoginResponse register(@RequestBody ProfileDetails profileDetails) {
        return profileService.register(profileDetails);
    }
}
