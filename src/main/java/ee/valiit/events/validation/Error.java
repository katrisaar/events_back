package ee.valiit.events.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_USERDATA("Sorri, nõu kän du", 111);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
