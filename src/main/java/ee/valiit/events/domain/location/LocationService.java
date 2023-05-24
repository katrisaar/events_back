package ee.valiit.events.domain.location;

import ee.valiit.events.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Resource
    private LocationRepository locationRepository;


    public void validateLocationIsAvailableBy(String newLocationName) {
        boolean locationExists = locationRepository.locationExistsBy(newLocationName);
        ValidationService.validateLocationAlreadyExists(locationExists);
    }

    public void addLocation(Location location) { locationRepository.save(location); }

}
