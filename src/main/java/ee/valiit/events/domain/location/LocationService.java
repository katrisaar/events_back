package ee.valiit.events.domain.location;

import ee.valiit.events.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Resource
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAllSortedByName();
    }

    public void validateLocationIsAvailableBy(String newLocationName) {
        boolean locationExists = locationRepository.locationExistsBy(newLocationName);
        ValidationService.validateLocationAlreadyExists(locationExists);
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public Location getLocationBy(Integer locationId) {
        return locationRepository.findById(locationId).get();
    }
}
