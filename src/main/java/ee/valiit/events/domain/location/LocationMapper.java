package ee.valiit.events.domain.location;

import ee.valiit.events.business.locations.LocationDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {
    Location toEntity(LocationDto locationDto);

    @Mapping(source = "name", target = "locationName")
    @Mapping(source = "id", target = "locationId")
    LocationDto toLocationDto(Location location);
    List<LocationDto> toLocationDtos(List<Location> location);




}