package ee.valiit.events.business.events.dto;

import ee.valiit.events.domain.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

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
    private Integer activityTypeId;
    private String activityTypeName;
    private Integer locationId;
    private String locationName;
    private Integer spotsMin;
    private Integer spotsMax;
    private Integer spotsAvailable;
    private Integer spotsTaken;
    private String addressDescription;
    private LocalDate registrationDate;
    private LocalDate startDate;
    private String startTime;
    private LocalDate endDate;
    private String endTime;
}