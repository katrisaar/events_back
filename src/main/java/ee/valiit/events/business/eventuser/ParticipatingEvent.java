package ee.valiit.events.business.eventuser;

import ee.valiit.events.domain.eventuser.EventUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link EventUser} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipatingEvent implements Serializable {
    private Integer eventId;
    private String eventName;
    private String locationName;
    private Integer fee;
    private LocalDate startDate;
}
