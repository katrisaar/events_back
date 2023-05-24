package ee.valiit.events.domain.event;

import ee.valiit.events.business.events.dto.EventDto;
import ee.valiit.events.business.events.dto.EventShorty;
import ee.valiit.events.domain.image.Image;
import ee.valiit.events.domain.user.contact.Contact;
import ee.valiit.events.domain.util.ImageUtil;
import org.mapstruct.*;
import ee.valiit.events.business.events.dto.EventDto;
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

    @Named("imageToImageData")
    static String contactImageToImageData(Image image) {
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }

}