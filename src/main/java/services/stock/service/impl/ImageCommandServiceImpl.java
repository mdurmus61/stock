package services.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.stock.entity.Image;
import services.stock.exception.StockException;
import services.stock.repository.ImageRepository;
import services.stock.service.ImageCommandService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ImageCommandServiceImpl implements ImageCommandService {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageCommandServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public String createImage(String code, byte[] contents) {
        Image image = new Image(code, contents);
        image = imageRepository.save(image);
        return image.getCode();
    }

    @Override
    public String updateImage(String code, byte[] contents) {
        Image image = imageRepository.findOneByCode(code);
        if(image == null)
            throw new StockException("RUN_TIME", "UPDATE_IMAGE", "Image is not found by code : " + code);

        image.applyEntityStamps();
        image.setImage(contents);
        image = imageRepository.save(image);
        return image.getCode();
    }
}
