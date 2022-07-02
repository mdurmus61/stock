package services.stock.request;

import services.stock.dto.ProductDTO;

import java.util.List;

public class CreateProductsRequest {
    private List<ProductDTO> createDTOS;

    public List<ProductDTO> getCreateDTOS() {
        return createDTOS;
    }

    public void setCreateDTOS(List<ProductDTO> createDTOS) {
        this.createDTOS = createDTOS;
    }
}
