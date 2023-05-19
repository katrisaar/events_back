package ee.valiit.events.domain.user.role;

import ee.valiit.events.business.UserRoleType;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;
    public Role getCustomerRoleBy() {
        return roleRepository.getRoleBy(UserRoleType.CUSTOMER.getTypeName());
    }
}
