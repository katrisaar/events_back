package ee.valiit.events.domain.spot;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SpotService {

    @Resource
    SpotRepository spotRepository;

    public void update(Spot spot) {
        spotRepository.save(spot);
    }
    public void addSpot(Spot spot) {
        spotRepository.save(spot);
    }

}
