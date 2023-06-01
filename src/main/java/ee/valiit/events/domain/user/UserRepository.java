package ee.valiit.events.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = ?1 and u.password = ?2 and u.status = ?3")
    Optional<User> findUserBy(String username, String password, String status);

    @Query("select (count(u) > 0) from User u where upper(u.username) = upper(?1) and u.status = ?2")
    boolean usernameAlreadyExistsBy(String username, String status);

    @Query("select u from User u order by u.status, u.role.name, u.contact.lastName, u.contact.firstName, u.username")
    List<User> findAllUsers();

    @Query("select (count(u) > 0) from User u where u.id <> ?1 and u.username = ?2")
    boolean editedUsernameAlreadyExistsBy(Integer id, String username);

    @Query("select u from User u where u.username = ?1 and u.status = ?2")
    Optional<User> findUserBy(String username, String status);
}