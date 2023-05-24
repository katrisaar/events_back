package ee.valiit.events.domain.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("select (count(l) > 0) from Location l where l.name = ?1")
    boolean locationExistsBy(String locationName);
}