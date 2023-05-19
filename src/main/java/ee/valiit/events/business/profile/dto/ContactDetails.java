package ee.valiit.events.business.profile.dto;

import ee.valiit.events.domain.user.contact.Contact;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Contact} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetails implements Serializable {
    @Size(max = 50)
    @NotNull
    private String firstName;
    @Size(max = 50)
    @NotNull
    private String lastName;
    @Size(max = 50)
    @NotNull
    private String email;
    @NotNull
    private byte[] imageData;
}