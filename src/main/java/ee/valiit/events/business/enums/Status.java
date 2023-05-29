package ee.valiit.events.business.enums;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A"),
    FILLED("F"),
    CANCELLED("C"),
    HISTORY("H"),
    DELETED("D");

    private final String status;

    Status(String status) {
        this.status = status;
    }
}
