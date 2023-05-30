package ee.valiit.events.domain.eventuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventUserRepository extends JpaRepository<EventUser, Integer> {

    @Query("""
            select e from EventUser e
            where e.user.id = ?1 and e.connectionType.name = ?2 and (e.status = ?3 or e.status = ?4)
            order by e.status, e.event.time.startDate""")
    List<EventUser> findAllActiveOrCancelledOrganisedEventUsersBy(Integer userId, String connectionTypeName, String statusActive, String statusCancelled);

    @Query("""
            select e from EventUser e
            where e.user.id = ?1 and e.connectionType.name = ?2 and (e.status = ?3 or e.status = ?4)
            order by e.status, e.event.time.startDate""")
    List<EventUser> findAllActiveOrCancelledParticipatingEventUsersBy(Integer userId, String ConnectionTypeName, String statusActive, String statusCancelled);

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
    Optional<EventUser> findSpecifiedStatusUserConnectionToEventBy(Integer eventId, Integer userId, String status);

    @Query("""
            select e from EventUser e
            where e.event.id = ?1 and e.user.id = ?2 and e.connectionType.name = ?3 and e.status = ?4""")
    Optional<EventUser> findActiveConnectionBy(Integer eventId, Integer userId, String connectionTypeName, String status);

    @Query("select e from EventUser e where e.event.id = ?1 and e.status = ?2")
    List<EventUser> findAllSpecifiedStatusEventConnectionsBy(Integer eventId, String status);

    @Query("select e from EventUser e where e.event.id = ?1")
    List<EventUser> findAllEventConnectionsToUsersBy(Integer eventId);

    @Query("""
            select e from EventUser e
            where e.user.id = ?1 and e.status = ?2
            order by e.event.time.startDate, e.event.name""")
    List<EventUser> findHistoryEventsBy(Integer userId, String status);

    @Query("select (count(e) > 0) from EventUser e where e.event.id = ?1 and e.user.id = ?2 and e.status = ?3")
    boolean activeConnectionExists(Integer eventId, Integer userId, String status);

}