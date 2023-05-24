package ee.valiit.events.domain.activitytype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Integer> {
    @Query("select (count(a) > 0) from ActivityType a where a.name = ?1")
    boolean activityTypeExistsBy(String activityTypeName);

}