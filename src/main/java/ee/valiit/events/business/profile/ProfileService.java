package ee.valiit.events.business.profile;

import ee.valiit.events.business.profile.dto.LoginResponse;
import ee.valiit.events.business.profile.dto.ProfileDetails;
import ee.valiit.events.domain.user.User;
import ee.valiit.events.domain.user.UserMapper;
import ee.valiit.events.domain.user.UserService;
import ee.valiit.events.domain.user.contact.Contact;
import ee.valiit.events.domain.user.contact.ContactMapper;
import ee.valiit.events.domain.user.contact.ContactService;
import ee.valiit.events.domain.user.role.Role;
import ee.valiit.events.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Resource
    private UserService userService;
    @Resource
    private ContactService contactService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ContactMapper contactMapper;

    public LoginResponse login(String username, String password) {
        User activeUser = userService.findActiveUser(username, password);
        return userMapper.toLoginResponse(activeUser);
    }

    public LoginResponse register(ProfileDetails profileDetails) {
        userService.validateUsernameIsAvailable(profileDetails.getUsername());
        Contact contact = contactMapper.toContact(profileDetails);
        contactService.addContact(contact);
        User user = userMapper.toUser(profileDetails);
        user.setContact(contact);
        Role role = roleService.getCustomerRoleBy();
        user.setRole(role);
        userService.addUser(user);
        return userMapper.toLoginResponse(user);

        // todo: kui oleme ära salvestanud, siis paneme loodud useri id ja rolename LoginResponse kujule
        // todo: ja anname selle LoginResponse tagasi kontrollerile
    }
}
