package ee.valiit.events.domain.image;

import ee.valiit.events.domain.util.ImageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Resource
    private ImageRepository imageRepository;

    public void addImage(Image image) {
        imageRepository.save(image);
    }

    public Image addImage(String imageData) {
        Image image = new Image();
        image.setData(ImageUtil.base64ImageDataToByteArray(imageData));
        imageRepository.save(image);
        return image;
    }

}
