package ee.valiit.events.domain.user.contact;

import ee.valiit.events.business.profile.dto.ProfileRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-22T14:41:45+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public Contact toContact(ProfileRequest profileRequest) {
        if ( profileRequest == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setFirstName( profileRequest.getFirstName() );
        contact.setLastName( profileRequest.getLastName() );
        contact.setEmail( profileRequest.getEmail() );

        return contact;
    }
}
