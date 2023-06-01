package ee.valiit.events.domain.connectiontype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConnectionTypeRepository extends JpaRepository<ConnectionType, Integer> {
    @Query("select c from ConnectionType c where c.name = ?1")
    ConnectionType getConnectionTypeBy(String name);
}