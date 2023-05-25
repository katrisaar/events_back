package ee.valiit.events.domain.event;

import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.business.events.dto.EventShorty;
import ee.valiit.events.domain.image.Image;
import ee.valiit.events.domain.util.ImageUtil;
import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {
    @Mapping(source = "time.startDate", target = "startDate")
    @Mapping(source = "id", target = "eventId")
    @Mapping(source = "time.registrationDate", target = "registrationDate")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "location.name", target = "locationName")
    @Mapping(source = "fee", target = "fee")
    @Mapping(source = "activityType.name", target = "activityTypeName")
    @Mapping(source = "spots.available", target = "spotsAvailable")
    EventDto toDto(Event event);

    List<EventDto> eventDtos(List<Event> events);

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
   @Mapping(source = "location.name", target = "locationName")
   @Mapping(source = "activityType.name", target = "activityTypeName")
   @Mapping(source = "time.registrationDate", target = "registrationDate")
   @Mapping(source = "time.startDate", target = "startDate")
   @Mapping(source = "time.startTime", target = "startTime")
   @Mapping(source = "time.endDate", target = "endDate")
   @Mapping(source = "time.endTime", target = "endTime")
   @Mapping(source = "address.description", target = "addressDescription")
   @Mapping(source = "spots.min", target = "spotsMin")
   @Mapping(source = "spots.max", target = "spotsMax")
   @Mapping(source = "spots.taken", target = "spotsTaken")
   @Mapping(source = "spots.available", target = "spotsAvailable")
    EventInfo toEventInfo(Event event);


    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }
}