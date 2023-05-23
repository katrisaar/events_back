package ee.valiit.events.domain.user;

import ee.valiit.events.business.Status;
import ee.valiit.events.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findActiveUser(String username, String password) {
        Optional<User> userOptional = userRepository.findUserBy(username, password, Status.ACTIVE.getStatus());
        ValidationService.validateCorrectUser(userOptional);
        return userOptional.get();
    }

    public void validateUsernameIsAvailable(String username) {
        boolean usernameAlreadyExists = userRepository.usernameAlreadyExistsBy(username, Status.ACTIVE.getStatus());
        ValidationService.validateUsernameAlreadyExists(usernameAlreadyExists);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAllUsers();

    }

    public User getUserBy(Integer userId) {
        return userRepository.findById(userId).get();
    }

    public void validateEditedUsernameIsAvailable(Integer userId, String username) {
        boolean editedUsernameAlreadyExists = userRepository.editedUsernameAlreadyExistsBy(userId, username);
        ValidationService.validateUsernameAlreadyExists(editedUsernameAlreadyExists);
    }
}
