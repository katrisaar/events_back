package ee.valiit.events.validation;

import ee.valiit.events.domain.event.Event;
import ee.valiit.events.domain.eventuser.EventUser;
import ee.valiit.events.domain.user.User;
import ee.valiit.events.infrastructure.exception.BusinessException;
import ee.valiit.events.infrastructure.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

public class ValidationService {

    public static void validateCorrectUser(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(Error.INCORRECT_USERDATA.getMessage(), Error.INCORRECT_USERDATA.getErrorCode());
        }
    }

    public static void validateUsernameAlreadyExists(boolean usernameAlreadyExists) {
        if (usernameAlreadyExists) {
            throw new BusinessException(Error.USERNAME_ALREADY_EXISTS.getMessage(), Error.USERNAME_ALREADY_EXISTS.getErrorCode());
        }
    }

    public static void validateLocationAlreadyExists(boolean locationExists) {
        if (locationExists) {
            throw new BusinessException(Error.LOCATION_ALREADY_EXISTS.getMessage(), Error.LOCATION_ALREADY_EXISTS.getErrorCode());
        }
    }

    public static void validateEventUserListExists(List<EventUser> eventUsers) {
        if (eventUsers.isEmpty()) {
            throw new DataNotFoundException(Error.EVENT_LIST_IS_EMPTY.getMessage(), Error.EVENT_LIST_IS_EMPTY.getErrorCode());
        }
    }

    public static void validateEventListExists(List<Event> events) {
        if (events.isEmpty()) {
            throw new DataNotFoundException(Error.EVENT_LIST_IS_EMPTY.getMessage(), Error.EVENT_LIST_IS_EMPTY.getErrorCode());
        }
    }

    public static void validateActivityTypeAlreadyExists(boolean activityTypeExists) {
        if (activityTypeExists) {
            throw new BusinessException(Error.ACTIVITY_TYPE_ALREADY_EXISTS.getMessage(), Error.ACTIVITY_TYPE_ALREADY_EXISTS.getErrorCode());
        }
    }

    public static void validateEventHasParticipants(List<EventUser> eventUsers) {
        if (eventUsers.isEmpty()) {
            throw new DataNotFoundException(Error.PARTICIPANTS_LIST_IS_EMPTY.getMessage(), Error.PARTICIPANTS_LIST_IS_EMPTY.getErrorCode());
        }
    }

    public static void validateUserExists(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new DataNotFoundException(Error.USERNAME_DOES_NOT_EXIST.getMessage(), Error.USERNAME_DOES_NOT_EXIST.getErrorCode());
        }
    }

    public static void validateUserAlreadyIsEventOrganiser(Optional<EventUser> eventUserOptional) {
        if (eventUserOptional.isPresent()) {
            throw new BusinessException(Error.USER_ALREADY_IS_ORGANISER.getMessage(), Error.USER_ALREADY_IS_ORGANISER.getErrorCode());
        }
    }
}
