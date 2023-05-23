package ee.valiit.events.domain.user;

import ee.valiit.events.business.enums.Status;
import ee.valiit.events.business.profile.dto.LoginResponse;
import ee.valiit.events.business.profile.dto.ProfileInfo;
import org.mapstruct.*;

import java.util.List;
import ee.valiit.events.business.profile.dto.ProfileInfoWithImage;
import ee.valiit.events.business.profile.dto.ProfileRequest;
import ee.valiit.events.domain.image.Image;
import ee.valiit.events.domain.user.contact.Contact;
import ee.valiit.events.domain.util.ImageUtil;

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

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "contact.firstName", target = "firstName")
    @Mapping(source = "contact.lastName", target = "lastName")
    @Mapping(source = "contact.email", target = "email")
    @Mapping(source = "role.name", target = "roleName")
    @Mapping(source = "status", target = "status")
    ProfileInfo toProfileInfo(User user);
    @Mapping(ignore = true, target = "password")
    User partialUpdate(ProfileRequest profileRequest, @MappingTarget User user);

    List<ProfileInfo> toProfileInfos(List<User> users);

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