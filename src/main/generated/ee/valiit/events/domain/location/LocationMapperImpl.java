package ee.valiit.events.domain.location;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-23T13:25:57+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class LocationMapperImpl implements LocationMapper {

    @Override
    public Location toEntity(LocationDto locationDto) {
        if ( locationDto == null ) {
            return null;
        }

        Location location = new Location();

        location.setId( locationDto.getId() );
        location.setName( locationDto.getName() );

        return location;
    }

    @Override
    public LocationDto toLocationDto(Location location) {
        if ( location == null ) {
            return null;
        }

        LocationDto locationDto = new LocationDto();

        locationDto.setId( location.getId() );
        locationDto.setName( location.getName() );

        return locationDto;
    }

    @Override
    public List<LocationDto> toLocationDtos(List<Location> location) {
        if ( location == null ) {
            return null;
        }

        List<LocationDto> list = new ArrayList<LocationDto>( location.size() );
        for ( Location location1 : location ) {
            list.add( toLocationDto( location1 ) );
        }

        return list;
    }

    @Override
    public Location partialUpdate(LocationDto locationDto, Location location) {
        if ( locationDto == null ) {
            return location;
        }

        if ( locationDto.getId() != null ) {
            location.setId( locationDto.getId() );
        }
        if ( locationDto.getName() != null ) {
            location.setName( locationDto.getName() );
        }

        return location;
    }
}
