package ee.valiit.events.domain.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("select l from Location l order by l.name")
    List<Location> findAllSortedByName();

    @Query("select (count(l) > 0) from Location l where upper(l.name) = upper(?1)")
    boolean locationExistsBy(String locationName);
}