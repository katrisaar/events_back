package ee.valiit.events.business.enums;

import lombok.Getter;

@Getter
public enum EventUserConnectionType {
    ORGANIZING("korraldaja"),
    PARTICIPATING("osaleja"),
    INTERESTED("huvitatud"),
    NONE("none");

    private final String typeName;

    EventUserConnectionType(String typeName) {
        this.typeName = typeName;
    }
}
