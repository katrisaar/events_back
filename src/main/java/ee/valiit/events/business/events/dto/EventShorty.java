package ee.valiit.events.business.events.dto;

import ee.valiit.events.domain.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
