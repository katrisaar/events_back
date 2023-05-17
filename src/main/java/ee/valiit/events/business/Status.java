package ee.valiit.events.business;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A"),
    DELETED("D");

    private final String status;

    Status(String status) {
        this.status = status;
    }
}
