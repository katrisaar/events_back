package ee.valiit.events.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A DTO for the {@link Event} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventInfo implements Serializable {
    private String eventName;
    private String description;
    private Integer fee;
    private String imageData;
    private String activityTypeName;
    private String locationName;
    private Integer spotsMin;
    private Integer spotsMax;
    private Integer spotsAvailable;
    private Integer spotsTaken;
    private String addressDescription;
    private LocalDate registrationDate;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;
}