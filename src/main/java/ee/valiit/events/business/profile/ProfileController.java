package ee.valiit.events.business.profile;

import ee.valiit.events.business.profile.dto.LoginResponse;
import ee.valiit.events.business.profile.dto.ProfileInfo;
import ee.valiit.events.business.profile.dto.ProfileInfoWithImage;
import ee.valiit.events.business.profile.dto.ProfileRequest;
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
public class ProfileController {
    @Resource
    private ProfileService profileService;

    @GetMapping("/login")
    @Operation(summary = "Sisse logimine. Tagastab userId ja roleName",
            description = """
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
            description = """
                    Loome süsteemi uue kasutaja ja logime ta ka kohe sisse.
                    Kui selgub, et soovitud kasutajanimi on sama, mis mõnel olemasoleval aktiivsel kasutajal, 
                    siis tagastame veatetate koodiga 222 
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Kahju küll, aga soovitud kasutajanimi on juba hõivatud. Proovi midagi muud.", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public LoginResponse register(@RequestBody ProfileRequest profileRequest) {
        return profileService.register(profileRequest);
    }

    @GetMapping("/profile")
    @Operation(summary = "Tagastab olemasoleva kasutaja detailse info userId alusel")
    public ProfileInfoWithImage getProfile(@RequestParam Integer userId) {
        return profileService.getProfile(userId);
    }

    @PutMapping("/profile")
    @Operation(summary = "Olemasoleva kasutaja andmete muutmine",
            description = """
                    Võtab sisse kasutaja userId ja muudab olemasoleva kasutaja andmeid.
                    Kui soovitakse muuta kasutajanime, aga soovitud kasutajanimi on sama, mis mõnel olemasoleval aktiivsel kasutajal, 
                    siis tagastame veatetate koodiga 222 
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Kahju küll, aga soovitud kasutajanimi on juba hõivatud. Proovi midagi muud.", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void editProfile(@RequestParam Integer userId, @RequestBody ProfileRequest profileRequest) {
        profileService.editProfile(userId, profileRequest);
    }

    @GetMapping("/admin")
    @Operation(summary = "Tagastab nii aktiivsete kui ka kustutatud kasutajate nimekirja koos infoga.",
            description = "Adminil on võimalik kasutajate infot kas muuta või kasutajaid süsteemist kustutada")
    public List<ProfileInfo> getAllUsers() {
        return profileService.getAllUsers();
    }

    @DeleteMapping("/profile")
    @Operation(summary = "Kustutab (märgib mitteaktiivseks) olemasoleva kasutaja userId alusel")
    public void deleteUser(@RequestParam Integer userId) {
        profileService.deleteUser(userId);
    }
}
