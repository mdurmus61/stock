package services.stock.service;


import services.stock.dto.ProductDTO;
import services.stock.dto.RateDefinitionDTO;

import java.util.List;

public interface ProductCommandService {
    List<ProductDTO> createProducts(List<ProductDTO> createDTOS);

    List<ProductDTO> updateProducts(List<ProductDTO> createDTOS);
}
