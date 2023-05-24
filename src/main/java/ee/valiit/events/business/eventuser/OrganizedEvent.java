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
public class OrganizedEvent implements Serializable {
    private Integer eventId;
    private String eventName;
    private Integer spotsAvailable;
    private Integer spotsTaken;
    private LocalDate registrationDate;
    private LocalDate startDate;
}