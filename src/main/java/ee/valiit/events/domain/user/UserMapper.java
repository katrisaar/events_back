package ee.valiit.events.domain.user;

import ee.valiit.events.business.Status;
import ee.valiit.events.business.profile.dto.LoginResponse;
import ee.valiit.events.business.profile.dto.ProfileDetails;
import ee.valiit.events.business.profile.dto.ProfileInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);

    @Mapping(expression = "java(Status.ACTIVE.getStatus())", target = "status")
    User toUser(ProfileDetails profileDetails);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "contact.firstName", target = "firstName")
    @Mapping(source = "contact.lastName", target = "lastName")
    @Mapping(source = "contact.email", target = "email")
    @Mapping(source = "role.name", target = "roleName")
    @Mapping(source = "status", target = "status")
    ProfileInfo toProfileInfo(User user);

    List<ProfileInfo> toProfileInfos(List<User> users);

}