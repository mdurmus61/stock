package services.stock.response;

import services.stock.dto.ProductDTO;
import services.stock.response.base.BaseApiResponse;

import java.util.List;

public class CreateProductsResponse extends BaseApiResponse {
    private List<ProductDTO> retValues;

    public CreateProductsResponse(String key, List<ProductDTO> retValues) {
        super(key, true);
        this.retValues = retValues;
    }

    public List<ProductDTO> getRetValues(){
        return retValues;
    }

    public void setRetValues(List<ProductDTO> retValues) {
        this.retValues = retValues;
    }
}
