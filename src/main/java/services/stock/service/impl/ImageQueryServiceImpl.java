package services.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.stock.dto.ImageDTO;
import services.stock.entity.Image;
import services.stock.repository.ImageRepository;
import services.stock.service.ImageQueryService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ImageQueryServiceImpl implements ImageQueryService {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageQueryServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    @Override
    public ImageDTO getImageByCode(String code) {
        Image image = imageRepository.findOneByCode(code);
        return image.toDTO();
    }
}
