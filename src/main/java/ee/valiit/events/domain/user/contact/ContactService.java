package ee.valiit.events.domain.user.contact;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }
}
