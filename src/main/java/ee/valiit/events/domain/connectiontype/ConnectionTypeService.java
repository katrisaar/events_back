package ee.valiit.events.domain.connectiontype;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ConnectionTypeService {
    @Resource
    ConnectionTypeRepository connectionTypeRepository;

    public ConnectionType getConnectionTypeBy(String typeName) {
        return connectionTypeRepository.getConnectionTypeBy(typeName);
    }
}
