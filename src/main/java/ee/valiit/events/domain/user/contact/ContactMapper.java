package ee.valiit.events.domain.user.contact;

import ee.valiit.events.business.profile.dto.ProfileRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {

    @Mapping(ignore = true, target = "image")
    Contact toContact(ProfileRequest profileRequest);
}