package ee.valiit.events.domain.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.status = ?1")
    List<Event> findActiveEventsBy(String status);


}