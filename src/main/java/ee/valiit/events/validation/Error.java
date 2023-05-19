package ee.valiit.events.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_USERDATA("Sorri, nõu kän du", 111),
    USERNAME_ALREADY_EXISTS("Kahju küll, aga soovitud kasutajanimi on juba hõivatud. Proovi midagi muud.", 222)    ;

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
