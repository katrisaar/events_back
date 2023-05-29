package ee.valiit.events.domain.time;

import ee.valiit.events.business.events.dto.EventInfo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T10:04:45+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (JetBrains s.r.o.)"
)
@Component
public class TimeMapperImpl implements TimeMapper {

    @Override
    public Time toTime(EventInfo eventInfo) {
        if ( eventInfo == null ) {
            return null;
        }

        Time time = new Time();

        time.setStartTime( TimeMapper.getLocalTimeFromString( eventInfo.getStartTime() ) );
        time.setEndTime( TimeMapper.getLocalTimeFromString( eventInfo.getEndTime() ) );
        time.setRegistrationDate( eventInfo.getRegistrationDate() );
        time.setStartDate( eventInfo.getStartDate() );
        time.setEndDate( eventInfo.getEndDate() );

        return time;
    }
}