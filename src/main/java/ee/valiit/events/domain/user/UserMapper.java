package ee.valiit.events.domain.user;

import ee.valiit.events.business.profile.dto.LoginResponse;
import ee.valiit.events.business.profile.dto.ProfileDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);

//    @Mapping(expression = "java(Status.ACTIVE.getStatus())", target = "status")
//    User toUser(ProfileDetails profileDetails);


//    @InheritInverseConfiguration(name = "toEntity")
//    ProfileDetails toDto(User user);
//
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    User partialUpdate(ProfileDetails profileDetails, @MappingTarget User user);
}