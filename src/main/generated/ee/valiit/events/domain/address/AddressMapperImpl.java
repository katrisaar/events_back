package ee.valiit.events.domain.address;

import ee.valiit.events.business.events.dto.EventInfo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T10:04:45+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (JetBrains s.r.o.)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toAddress(EventInfo eventInfo) {
        if ( eventInfo == null ) {
            return null;
        }

        Address address = new Address();

        address.setDescription( eventInfo.getAddressDescription() );

        return address;
    }
}
