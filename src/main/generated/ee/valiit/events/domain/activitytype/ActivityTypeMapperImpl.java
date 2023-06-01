package ee.valiit.events.domain.activitytype;

import ee.valiit.events.business.activitytypes.ExistingActivityTypes;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-01T13:40:16+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ActivityTypeMapperImpl implements ActivityTypeMapper {

    @Override
    public ExistingActivityTypes toActivityTypeDto(ActivityType activityType) {
        if ( activityType == null ) {
            return null;
        }

        ExistingActivityTypes existingActivityTypes = new ExistingActivityTypes();

        existingActivityTypes.setActivityTypeId( activityType.getId() );
        existingActivityTypes.setActivityTypeName( activityType.getName() );

        return existingActivityTypes;
    }

    @Override
    public List<ExistingActivityTypes> toDtos(List<ActivityType> activityTypes) {
        if ( activityTypes == null ) {
            return null;
        }

        List<ExistingActivityTypes> list = new ArrayList<ExistingActivityTypes>( activityTypes.size() );
        for ( ActivityType activityType : activityTypes ) {
            list.add( toActivityTypeDto( activityType ) );
        }

        return list;
    }
}
