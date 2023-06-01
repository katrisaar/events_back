package ee.valiit.events.domain.activitytype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Integer> {

    @Query("select a from ActivityType a order by a.name")
    List<ActivityType> findAllBySortedName();

    @Query("select (count(a) > 0) from ActivityType a where upper(a.name) = upper(?1)")
    boolean activityTypeExistsBy(String activityTypeName);
}