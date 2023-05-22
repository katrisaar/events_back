package ee.valiit.events.business.profile;

import ee.valiit.events.business.profile.dto.LoginResponse;
import ee.valiit.events.business.profile.dto.ProfileInfoWithImage;
import ee.valiit.events.business.profile.dto.ProfileRequest;
import ee.valiit.events.domain.image.Image;
import ee.valiit.events.domain.image.ImageService;
import ee.valiit.events.domain.user.User;
import ee.valiit.events.domain.user.UserMapper;
import ee.valiit.events.domain.user.UserService;
import ee.valiit.events.domain.user.contact.Contact;
import ee.valiit.events.domain.user.contact.ContactMapper;
import ee.valiit.events.domain.user.contact.ContactService;
import ee.valiit.events.domain.user.role.Role;
import ee.valiit.events.domain.user.role.RoleService;
import ee.valiit.events.domain.util.ImageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileService {

    @Resource
    private UserService userService;
    @Resource
    private ContactService contactService;
    @Resource
    private RoleService roleService;
    @Resource
    ImageService imageService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ContactMapper contactMapper;

    public LoginResponse login(String username, String password) {
        User activeUser = userService.findActiveUser(username, password);
        return userMapper.toLoginResponse(activeUser);
    }

    @Transactional
    public LoginResponse register(ProfileRequest profileRequest) {
        userService.validateUsernameIsAvailable(profileRequest.getUsername());
        Contact contact = contactMapper.toContact(profileRequest);
        contactService.addContact(contact);
        User user = userMapper.toUser(profileRequest);
        user.setContact(contact);
        Role role = roleService.getCustomerRoleBy();
        user.setRole(role);
        userService.addUser(user);
        return userMapper.toLoginResponse(user);
    }

    public ProfileInfoWithImage getProfile(Integer userId) {
        User user = userService.getUserBy(userId);
        return userMapper.toProfileInfoWithImage(user);
    }

    @Transactional
    public void editProfile(Integer userId, ProfileRequest profileRequest) {
        userService.validateEditedUsernameIsAvailable(userId, profileRequest.getUsername());
        User user = userService.getUserBy(userId);
        updateUsernameAndPassword(profileRequest, user);
        Contact contact = user.getContact();
        updateContactData(profileRequest, contact);
        handleImageChange(contact, profileRequest.getImageData());
        userService.addUser(user);
    }

    private void updateContactData(ProfileRequest profileRequest, Contact contact) {
        contact.setFirstName(profileRequest.getFirstName());
        contact.setLastName(profileRequest.getLastName());
        contact.setEmail(profileRequest.getEmail());
        contactService.addContact(contact);
    }

    private void updateUsernameAndPassword(ProfileRequest profileRequest, User user) {
        userMapper.partialUpdate(profileRequest, user);
        if (!profileRequest.getPassword().isEmpty()) {
            user.setPassword(profileRequest.getPassword());
        }
    }

    private void handleImageChange(Contact contact, String imageDataFromUpdate) {
        Image currentImage = contact.getImage();

        if (currentImageUpdateIsRequired(currentImage, imageDataFromUpdate)) {
            currentImage.setData(ImageUtil.base64ImageDataToByteArray(imageDataFromUpdate));
        }

        if (newImageIsRequired(imageDataFromUpdate, currentImage)) {
            Image image = new Image(ImageUtil.base64ImageDataToByteArray(imageDataFromUpdate));
            contact.setImage(image);
            imageService.addImage(image);
        }

    }

    private boolean newImageIsRequired(String imageDataFromUpdate, Image currentImage) {
        return currentImage == null && !imageDataFromUpdate.isEmpty();
    }

    private boolean currentImageUpdateIsRequired(Image currectImage, String imageDataFromUpdate) {
        return ImageUtil.imageIsPresent(currectImage) && !imageDataFromUpdate.equals((ImageUtil.byteArrayToBase64ImageData(currectImage.getData())));
    }
}
