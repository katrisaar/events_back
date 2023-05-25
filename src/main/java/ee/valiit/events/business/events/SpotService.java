package ee.valiit.events.business.events;

import ee.valiit.events.domain.spot.Spot;
import ee.valiit.events.domain.spot.SpotRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SpotService {
    @Resource
    SpotRepository spotRepository;
    public void addSpot(Spot spot) {
        spotRepository.save(spot);
    }
}
