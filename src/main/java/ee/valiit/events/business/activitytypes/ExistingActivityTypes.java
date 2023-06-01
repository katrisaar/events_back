package ee.valiit.events.business.activitytypes;

import ee.valiit.events.domain.activitytype.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link ActivityType} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExistingActivityTypes implements Serializable {
    private Integer activityTypeId;
    private String activityTypeName;
}