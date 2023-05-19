package ee.valiit.events.domain.user.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.name = ?1")
    Role getRoleBy(String roleName);

}