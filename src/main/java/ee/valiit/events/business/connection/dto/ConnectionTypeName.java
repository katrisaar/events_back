package ee.valiit.events.business.connection.dto;

import ee.valiit.events.domain.eventuser.EventUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link EventUser} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionTypeName {
    private String name;
}
