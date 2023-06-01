package ee.valiit.events.domain.time;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TimeService {
    @Resource
    private TimeRepository timeRepository;

    public void addTime(Time time) {
        timeRepository.save(time);
    }
}
