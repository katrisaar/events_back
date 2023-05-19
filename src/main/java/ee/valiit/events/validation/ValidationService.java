package ee.valiit.events.validation;

import ee.valiit.events.domain.user.User;
import ee.valiit.events.infrastructure.exception.BusinessException;

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
}
