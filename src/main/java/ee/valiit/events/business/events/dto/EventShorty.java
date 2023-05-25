package ee.valiit.events.business.events.dto;

import ee.valiit.events.domain.event.Event;
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
public class EventShorty {
    private Integer eventId;
    private String eventName;
    private String imageData;
    private String locationName;
}