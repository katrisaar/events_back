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
public class ProfileInfo implements Serializable {

    private Integer userId;
    private String username;
    private String roleName;
    private String status;
    private String firstName;
    private String lastName;
    private String email;
}