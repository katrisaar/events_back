package ee.valiit.events.domain.location;

import ee.valiit.events.business.locations.LocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "id", target = "locationId")
    LocationDto toLocationDto(Location location);

    List<LocationDto> toLocationDtos(List<Location> location);
}