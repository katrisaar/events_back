package ee.valiit.events.domain.event;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class EventDto implements Serializable {
    @Size(max = 255)
    @NotNull
    private String name;
    private Integer fee;
    @Size(max = 255)
    @NotNull
    private String activityTypeName;
    @Size(max = 255)
    @NotNull
    private String locationName;
    @NotNull
    private Integer spotsAvailable;
    @NotNull
    private LocalDate registrationDate;
    @NotNull
    private LocalDate startDate;
}