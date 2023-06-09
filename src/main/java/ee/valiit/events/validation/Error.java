package ee.valiit.events.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_USERDATA("Sorri, nõu kän du", 111),
    USERNAME_ALREADY_EXISTS("Kahju küll, aga soovitud kasutajanimi on juba hõivatud. Proovi midagi muud.", 222),
    USERNAME_DOES_NOT_EXIST("Ei ole sellise kasutajanimega kasutajat.", 224),
    LOCATION_ALREADY_EXISTS("Sellise nimega asukoht on nimekirjas juba olemas. Saad selle valida nimekirjast.", 333),
    ACTIVITY_TYPE_ALREADY_EXISTS("Sellise nimega valdkond on nimekirjas juba olemas. Saad selle valida nimekirjast.", 444),
    EVENT_LIST_IS_EMPTY("Ei ole ühtegi üritust", 555),
    PARTICIPANTS_LIST_IS_EMPTY("Ei ole veel ühtegi osalejat.", 666),
    USER_ALREADY_IS_ORGANISER("See kasutaja juba on antud ürituse korraldaja", 668);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
