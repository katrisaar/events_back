package ee.valiit.events.domain.user;

import ee.valiit.events.business.Status;
import ee.valiit.events.business.profile.dto.LoginResponse;
import ee.valiit.events.business.profile.dto.ProfileDetails;
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
    User toUser(ProfileDetails profileDetails);

    @Mapping(source = "contact.firstName", target = "firstName")
    @Mapping(source = "contact.lastName", target = "lastName")
    @Mapping(source = "contact.email", target = "email")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
  //  @Mapping(source = "contact", target = "imageData", qualifiedByName = "contactImageToImageData")
    ProfileDetails toProfileDetails(User user);

    @Named("imageDataToImage")
    static Image imageDataToImage(String imageData) {
        if (imageData.isEmpty()) {
            return null;
        }
        return new Image(ImageUtil.base64ImageDataToByteArray(imageData));
    }

    @Named("contactImageToImageData")
    static String imageToImageData(Contact contact) {
        Image image = contact.getImage();
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }

//    @InheritInverseConfiguration(name = "toEntity")
//    ProfileDetails toDto(User user);
//
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    User partialUpdate(ProfileDetails profileDetails, @MappingTarget User user);
}