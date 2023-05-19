package ee.valiit.events.business.profile;

import ee.valiit.events.business.profile.dto.LoginResponse;
import ee.valiit.events.business.profile.dto.ProfileDetails;
import ee.valiit.events.domain.user.User;
import ee.valiit.events.domain.user.UserMapper;
import ee.valiit.events.domain.user.UserService;
import ee.valiit.events.domain.user.contact.Contact;
import ee.valiit.events.domain.user.contact.ContactMapper;
import ee.valiit.events.domain.user.contact.ContactService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Resource
    private UserService userService;
    @Resource
    private ContactService contactService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ContactMapper contactMapper;

    public LoginResponse login(String username, String password) {
        User activeUser = userService.findActiveUser(username, password);
        return userMapper.toLoginResponse(activeUser);
    }

    public void register(ProfileDetails profileDetails) {
        userService.validateUsernameIsAvailable(profileDetails.getUsername());
        Contact contact = contactMapper.toContact(profileDetails);
        contactService.addContact(contact);

        // todo: kõigepealt mapime contacti contactmapperiga
        //  todo: siis salvestame contacti ära

        // todo: siis mäpime ära useri,
        //  paneme setteriga kontakti külge ja
        //  salvestame useri
        // todo: kui oleme ära salvestanud, siis paneme loodud useri id ja rolename LoginResponse kujule
        // todo: ja anname selle LoginResponse tagasi kontrollerile
    }
}
