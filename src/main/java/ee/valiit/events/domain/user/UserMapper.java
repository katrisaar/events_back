package ee.valiit.events.domain.user;

import ee.valiit.events.business.Status;
import ee.valiit.events.business.profile.dto.LoginResponse;
import ee.valiit.events.business.profile.dto.ProfileInfoWithImage;
import ee.valiit.events.business.profile.dto.ProfileRequest;
import ee.valiit.events.domain.image.Image;
import ee.valiit.events.domain.user.contact.Contact;
import ee.valiit.events.domain.util.ImageUtil;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);

    @Mapping(expression = "java(Status.ACTIVE.getStatus())", target = "status")
    User toUser(ProfileRequest profileRequest);

    @Mapping(source = "contact.firstName", target = "firstName")
    @Mapping(source = "contact.lastName", target = "lastName")
    @Mapping(source = "contact.email", target = "email")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "contact", target = "imageData", qualifiedByName = "contactImageToImageData")
    ProfileInfoWithImage toProfileInfoWithImage(User user);

    @Mapping(ignore = true, target = "password")
    User partialUpdate(ProfileRequest profileRequest, @MappingTarget User user);

    @Named("imageDataToImage")
    static Image imageDataToImage(String imageData) {
        if (imageData.isEmpty()) {
            return null;
        }
        return new Image(ImageUtil.base64ImageDataToByteArray(imageData));
    }

    @Named("contactImageToImageData")
    static String contactImageToImageData(Contact contact) {
        Image image = contact.getImage();
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }

}