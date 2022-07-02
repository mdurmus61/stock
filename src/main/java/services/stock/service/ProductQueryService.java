package services.stock.service;


import services.stock.dto.ProductDTO;

import java.util.List;

public interface ProductQueryService {
    List<ProductDTO> getProductByTypeAndName(String type, String name);

    List<ProductDTO> getAllProducts();

}
