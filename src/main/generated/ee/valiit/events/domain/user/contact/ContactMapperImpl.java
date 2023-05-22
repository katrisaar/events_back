package ee.valiit.events.domain.user.contact;

import ee.valiit.events.business.profile.dto.ProfileDetails;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-21T19:15:33+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public Contact toContact(ProfileDetails profileDetails) {
        if ( profileDetails == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setFirstName( profileDetails.getFirstName() );
        contact.setLastName( profileDetails.getLastName() );
        contact.setEmail( profileDetails.getEmail() );

        return contact;
    }
}
