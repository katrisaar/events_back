package ee.valiit.events.business.location;

import ee.valiit.events.domain.location.Location;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Location} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto implements Serializable {
    private Integer locationId;
    @Size(max = 255)
    @NotNull
    private String locationName;
}