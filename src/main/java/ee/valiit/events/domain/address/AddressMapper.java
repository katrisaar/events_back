package ee.valiit.events.domain.address;

import ee.valiit.events.business.events.dto.EventInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    @Mapping(source = "addressDescription", target = "description")
    Address toAddress(EventInfo eventInfo);

}