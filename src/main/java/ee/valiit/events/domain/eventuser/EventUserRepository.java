package ee.valiit.events.domain.eventuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventUserRepository extends JpaRepository<EventUser, Integer> {
    @Query("select e from EventUser e where e.user.id = ?1 and e.connectionType.name = ?2 and e.status = ?3")
    List<EventUser> findAllActiveOrganisedEventUsersBy(Integer userId, String connectionTypeName, String status);

    @Query("""
            select e from EventUser e
            where e.user.id = ?1 and e.connectionType.name = ?2 and e.status = ?3
            order by e.event.time.startDate""")
    List<EventUser> findAllActiveParticipatingEventUsersBy(Integer id, String name, String status);

    @Query("""
            select e from EventUser e
            where e.user.id = ?1 and e.connectionType.name = ?2 and e.status = ?3
            order by e.event.time.startDate""")
    List<EventUser> findAllActiveInterestedEventUsersBy(Integer id, String name, String status);




}