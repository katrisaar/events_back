package ee.valiit.events.domain.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.status = ?1")
    List<Event> findActiveEventsBy(String status);

    @Query("select e from Event e where e.status = ?1 order by e.time.registrationDate limit 3")
    List<Event> findThreeActiveSoonToEndEventsBy(String status);

    @Query("select e from Event e where e.status = ?1 order by e.spots.available limit 3")
    List<Event> findThreeActiveSoonToFillEventsBy(String status);

    @Query("select e from Event e where e.status = ?1 order by e.id DESC limit 3")
    List<Event> findThreeActiveMostRecentEventsBy(String status);

    @Query("select e from Event e where e.status = ?1 and e.time.registrationDate < ?2")
    List<Event> FindEventsWithEndedRegistration(String status, LocalDate currentDate);

    @Query("select e from Event e where (e.status = ?1 or e.status = ?2) and e.time.endDate < ?3")
    List<Event> findEndedActiveOrFilledEventsBy(String status, String status1, LocalDate endDate);

    @Query("select e from Event e where e.status = ?1 and e.time.endDate < ?2")
    List<Event> findSpecificStatusEventsWhatHaveEnded(String status, LocalDate endDate);


}