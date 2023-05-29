package ee.valiit.events.business.connection.dto;

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
public class InterestedEvent implements Serializable {
    private Integer eventId;
    private String eventName;
    private LocalDate registrationDate;
    private LocalDate startDate;
    private String locationName;
    private Integer spotsAvailable;
}
