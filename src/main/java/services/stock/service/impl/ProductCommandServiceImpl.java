package services.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.stock.dto.ProductDTO;
import services.stock.entity.Product;
import services.stock.repository.ImageRepository;
import services.stock.repository.ProductRepository;
import services.stock.service.ProductCommandService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public ProductCommandServiceImpl(ProductRepository productRepository, ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public List<ProductDTO> createProducts(List<ProductDTO> createDTOS) {
        List<ProductDTO> list = new ArrayList<>();
        for(ProductDTO dto: createDTOS) {
            list.add(productRepository.save(new Product().fromDTO(imageRepository, dto)).toDTO());
        }

        return list;
    }

    @Override
    public List<ProductDTO> updateProducts(List<ProductDTO> createDTOS) {
        List<ProductDTO> list = new ArrayList<>();
        for(ProductDTO dto: createDTOS) {
            Product product = productRepository.findOneByTypeAndName(dto.getType(), dto.getName());
            product.applyEntityStamps();
            product.setAmount(dto.getAmount());
            product.setImage(imageRepository.findOneByCode(dto.getImageCode()));
            list.add(productRepository.save(product).toDTO());
        }

        return list;
    }
}
