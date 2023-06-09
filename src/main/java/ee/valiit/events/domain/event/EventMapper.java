package ee.valiit.events.domain.event;

import ee.valiit.events.business.enums.Status;
import ee.valiit.events.business.events.dto.EventInfo;
import ee.valiit.events.business.events.dto.EventShorty;
import ee.valiit.events.business.events.dto.EventSimple;
import ee.valiit.events.domain.image.Image;
import ee.valiit.events.domain.util.ImageUtil;
import ee.valiit.events.domain.util.TimeUtil;
import org.mapstruct.*;

import java.time.LocalTime;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface EventMapper {
    @Mapping(source = "time.startDate", target = "startDate")
    @Mapping(source = "id", target = "eventId")
    @Mapping(source = "time.registrationDate", target = "registrationDate")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "location.name", target = "locationName")
    @Mapping(source = "fee", target = "fee")
    @Mapping(source = "activityType.name", target = "activityTypeName")
    @Mapping(source = "spots.available", target = "spotsAvailable")
    EventSimple toDto(Event event);

    List<EventSimple> eventDtos(List<Event> events);

    @Mapping(source = "id", target = "eventId")
    @Mapping(source = "name", target = "eventName")
    @Mapping(source = "location.name", target = "locationName")
    @Mapping(source = "image", target = "imageData", qualifiedByName = "imageToImageData")
    EventShorty toEventShorty(Event event);

    List<EventShorty> toEventShortys(List<Event> event);

    @Mapping(source = "name", target = "eventName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "image", target = "imageData", qualifiedByName = "imageToImageData")
    @Mapping(source = "fee", target = "fee")
    @Mapping(source = "location.id", target = "locationId")
    @Mapping(source = "location.name", target = "locationName")
    @Mapping(source = "activityType.id", target = "activityTypeId")
    @Mapping(source = "activityType.name", target = "activityTypeName")
    @Mapping(source = "time.registrationDate", target = "registrationDate")
    @Mapping(source = "time.startDate", target = "startDate")
    @Mapping(source = "time.startTime", target = "startTime", qualifiedByName = "getStringFromLocalTime")
    @Mapping(source = "time.endDate", target = "endDate")
    @Mapping(source = "time.endTime", target = "endTime", qualifiedByName = "getStringFromLocalTime")
    @Mapping(source = "address.description", target = "addressDescription")
    @Mapping(source = "spots.min", target = "spotsMin")
    @Mapping(source = "spots.max", target = "spotsMax")
    @Mapping(source = "spots.taken", target = "spotsTaken")
    @Mapping(source = "spots.available", target = "spotsAvailable")
    EventInfo toEventInfo(Event event);

    @Mapping(expression = "java(Status.ACTIVE.getStatus())", target = "status")
    @Mapping(source = "eventName", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "fee", target = "fee")
    Event toEvent(EventInfo eventInfo);

    @Mapping(source = "description", target = "description")
    @Mapping(source = "fee", target = "fee")
    @Mapping(source = "eventName", target = "name")
    @Mapping(expression = "java(Status.ACTIVE.getStatus())", target = "status")
    Event partialUpdate(EventInfo eventInfo, @MappingTarget Event event);

    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }

    @Named("getStringFromLocalTime")
    static String getStringFromLocalTime(LocalTime localTime) {
        return TimeUtil.getStringFromLocalTime(localTime);
    }
}