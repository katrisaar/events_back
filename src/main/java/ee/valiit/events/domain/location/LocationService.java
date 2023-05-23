package ee.valiit.events.domain.location;

import ee.valiit.events.business.location.LocationDto;
import ee.valiit.events.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Resource
    private LocationRepository locationRepository;


    public void validateLocationIsAvailableBy(LocationDto newLocationName) {
        boolean locationExists = locationRepository.locationExistsBy(newLocationName);
        ValidationService.validateLocationAlreadyExists(locationExists);
    }
}
