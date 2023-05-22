package ee.valiit.events.domain.image;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Resource
    private ImageRepository imageRepository;

    public void addImage(Image image) {
        imageRepository.save(image);
    }
}
