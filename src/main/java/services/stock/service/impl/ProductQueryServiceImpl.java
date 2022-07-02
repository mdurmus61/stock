package services.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.stock.dto.ProductDTO;
import services.stock.entity.Product;
import services.stock.repository.ProductRepository;
import services.stock.service.ProductQueryService;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductDTO> getProductByTypeAndName(String type, String name) {
        return Collections.singletonList(productRepository.findOneByTypeAndName(type, name).toDTO());
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(Product::toDTO).collect(toList());
    }
}
