package ee.valiit.events.domain.user;

import ee.valiit.events.business.Status;
import ee.valiit.events.business.profile.dto.LoginResponse;
import ee.valiit.events.business.profile.dto.ProfileDetails;
import ee.valiit.events.business.profile.dto.ProfileInfo;
import ee.valiit.events.domain.user.contact.Contact;
import ee.valiit.events.domain.user.role.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-22T11:49:10+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public LoginResponse toLoginResponse(User user) {
        if ( user == null ) {
            return null;
        }

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setUserId( user.getId() );
        loginResponse.setRoleName( userRoleName( user ) );

        return loginResponse;
    }

    @Override
    public User toUser(ProfileDetails profileDetails) {
        if ( profileDetails == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( profileDetails.getUsername() );
        user.setPassword( profileDetails.getPassword() );

        user.setStatus( Status.ACTIVE.getStatus() );

        return user;
    }

    @Override
    public ProfileInfo toProfileInfo(User user) {
        if ( user == null ) {
            return null;
        }

        ProfileInfo profileInfo = new ProfileInfo();

        profileInfo.setUserId( user.getId() );
        profileInfo.setUsername( user.getUsername() );
        profileInfo.setFirstName( userContactFirstName( user ) );
        profileInfo.setLastName( userContactLastName( user ) );
        profileInfo.setEmail( userContactEmail( user ) );
        profileInfo.setRoleName( userRoleName( user ) );
        profileInfo.setStatus( user.getStatus() );

        return profileInfo;
    }

    @Override
    public List<ProfileInfo> toProfileInfos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<ProfileInfo> list = new ArrayList<ProfileInfo>( users.size() );
        for ( User user : users ) {
            list.add( toProfileInfo( user ) );
        }

        return list;
    }

    private String userRoleName(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        String name = role.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String userContactFirstName(User user) {
        if ( user == null ) {
            return null;
        }
        Contact contact = user.getContact();
        if ( contact == null ) {
            return null;
        }
        String firstName = contact.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String userContactLastName(User user) {
        if ( user == null ) {
            return null;
        }
        Contact contact = user.getContact();
        if ( contact == null ) {
            return null;
        }
        String lastName = contact.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String userContactEmail(User user) {
        if ( user == null ) {
            return null;
        }
        Contact contact = user.getContact();
        if ( contact == null ) {
            return null;
        }
        String email = contact.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }
}
