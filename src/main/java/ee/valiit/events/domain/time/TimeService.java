package ee.valiit.events.domain.time;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class TimeService {
    @Resource
    TimeRepository timeRepository;
    public void addTime(Time time) {
//        time.setDateCreated(Instant.from(LocalDateTime.now()));
        timeRepository.save(time);
    }

}
