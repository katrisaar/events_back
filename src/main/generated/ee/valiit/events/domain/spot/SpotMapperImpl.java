package ee.valiit.events.domain.spot;

import ee.valiit.events.business.events.dto.EventInfo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T10:04:44+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (JetBrains s.r.o.)"
)
@Component
public class SpotMapperImpl implements SpotMapper {

    @Override
    public Spot toSpot(EventInfo eventInfo) {
        if ( eventInfo == null ) {
            return null;
        }

        Spot spot = new Spot();

        spot.setAvailable( eventInfo.getSpotsMax() );
        spot.setMax( eventInfo.getSpotsMax() );
        spot.setMin( eventInfo.getSpotsMin() );
        spot.setTaken( eventInfo.getSpotsTaken() );

        return spot;
    }
}
