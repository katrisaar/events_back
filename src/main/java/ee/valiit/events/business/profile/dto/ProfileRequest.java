package ee.valiit.events.business.profile.dto;

import ee.valiit.events.domain.user.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest implements Serializable {
    @Size(max = 50)
    @NotNull
    private String username;
    @Size(max = 50)
    @NotNull
    private String password;
    @Size(max = 50)
    @NotNull
    private String firstName;
    @Size(max = 50)
    @NotNull
    private String lastName;
    @Size(max = 50)
    @NotNull
    private String email;
    private String imageData;
}