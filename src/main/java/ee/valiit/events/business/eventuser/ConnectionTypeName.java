package ee.valiit.events.business.eventuser;

import ee.valiit.events.domain.eventuser.EventUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link EventUser} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionTypeName {
    private String name;
}
