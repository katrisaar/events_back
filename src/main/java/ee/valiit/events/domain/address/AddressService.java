package ee.valiit.events.domain.address;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Resource
    AddressRepository addressRepository;

    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    public Address getAddress(Integer eventId) {
        return addressRepository.findById(eventId).get();
    }
}
