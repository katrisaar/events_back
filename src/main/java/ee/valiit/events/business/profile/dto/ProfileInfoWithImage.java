package ee.valiit.events.business.profile.dto;

import ee.valiit.events.domain.user.User;
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
public class ProfileInfoWithImage implements Serializable {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String imageData;
}