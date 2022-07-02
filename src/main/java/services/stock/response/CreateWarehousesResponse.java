package services.stock.response;

import services.stock.dto.WarehouseDTO;
import services.stock.response.base.BaseApiResponse;

import java.util.List;

public class CreateWarehousesResponse extends BaseApiResponse {
    private List<WarehouseDTO> retValues;

    public CreateWarehousesResponse(String key, List<WarehouseDTO> retValues) {
        super(key, true);
        this.retValues = retValues;
    }

    public List<WarehouseDTO> getRetValues(){
        return retValues;
    }

    public void setRetValues(List<WarehouseDTO> retValues) {
        this.retValues = retValues;
    }
}
