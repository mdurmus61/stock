package services.stock.request;

import services.stock.dto.WarehouseDTO;

import java.util.List;

public class CreateWarehousesRequest {
    private List<WarehouseDTO> createDTOS;

    public List<WarehouseDTO> getCreateDTOS() {
        return createDTOS;
    }

    public void setCreateDTOS(List<WarehouseDTO> createDTOS) {
        this.createDTOS = createDTOS;
    }
}
