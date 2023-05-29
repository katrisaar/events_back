package ee.valiit.events.domain.eventuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventUserRepository extends JpaRepository<EventUser, Integer> {
    @Query("select e from EventUser e where e.user.id = ?1 and e.connectionType.name = ?2 and e.status = ?3")
    List<EventUser> findAllActiveOrganisedEventUsersBy(Integer userId, String connectionTypeName, String status);

    @Query("""
            select e from EventUser e
            where e.user.id = ?1 and e.connectionType.name = ?2 and e.status = ?3
            order by e.event.time.startDate""")
    List<EventUser> findAllActiveParticipatingEventUsersBy(Integer userId, String ConnectionTypeName, String status);

    @Query("""
            select e from EventUser e
            where e.user.id = ?1 and e.connectionType.name = ?2 and e.status = ?3
            order by e.event.time.startDate""")
    List<EventUser> findAllActiveInterestedEventUsersBy(Integer userId, String ConnectionTypeName, String status);

    @Query("""
            select e from EventUser e
            where e.event.id = ?1 and e.connectionType.name = ?2 and e.status = ?3
            order by e.user.contact.lastName, e.user.contact.firstName""")
    List<EventUser> getActiveEventOrganisersBy(Integer eventId, String ConnectionTypeName, String status);

    @Query("""
            select e from EventUser e
            where e.event.id = ?1 and e.connectionType.name = ?2 and e.status = ?3
            order by e.user.contact.lastName, e.user.contact.firstName""")
    List<EventUser> findActiveEventParticipantsBy(Integer eventId, String ConnectionTypeName, String status);

    @Query("select e from EventUser e where e.event.id = ?1 and e.user.id = ?2 and e.status = ?3")
    Optional<EventUser> findActiveUserConnectionToEventBy(Integer eventId, Integer userId, String status);

    @Query("""
            select e from EventUser e
            where e.event.id = ?1 and e.user.id = ?2 and e.connectionType.name = ?3 and e.status = ?4""")
    Optional<EventUser> findActiveConnectionBy(Integer eventId, Integer userId, String connectionTypeName, String status);


}