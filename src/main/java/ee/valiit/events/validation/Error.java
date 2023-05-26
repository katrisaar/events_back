package ee.valiit.events.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_USERDATA("Sorri, nõu kän du", 111),
    USERNAME_ALREADY_EXISTS("Kahju küll, aga soovitud kasutajanimi on juba hõivatud. Proovi midagi muud.", 222),
    LOCATION_ALREADY_EXISTS("Sellise nimega asukoht on nimekirjas juba olemas.", 333),
    ACTIVITY_TYPE_ALREADY_EXISTS("Selline tegevusvaldkond on juba olemas. Saad selle valida nimekirjast.", 444),
    EVENT_LIST_IS_EMPTY("Ei ole ühtegi üritust", 555),
    PARTICIPANTS_LIST_IS_EMPTY("Ei ole veel ühtegi osalejat.", 666);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
