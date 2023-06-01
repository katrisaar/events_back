package ee.valiit.events.business.locations;

import ee.valiit.events.domain.location.Location;
import ee.valiit.events.domain.location.LocationMapper;
import ee.valiit.events.domain.location.LocationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsService {
    @Resource
    LocationService locationService;
    @Resource
    LocationMapper locationMapper;

    public List<LocationDto> getLocations() {
        List<Location> allLocations = locationService.getAllLocations();
        return locationMapper.toLocationDtos(allLocations);
    }

    public LocationDto addLocation(String locationName) {
        locationService.validateLocationIsAvailableBy(locationName);
        Location location = new Location(locationName);
        locationService.addLocation(location);
        return locationMapper.toLocationDto(location);
    }
}
