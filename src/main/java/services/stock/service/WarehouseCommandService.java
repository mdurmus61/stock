package services.stock.service;


import services.stock.dto.WarehouseDTO;

import java.util.List;

public interface WarehouseCommandService {
    List<WarehouseDTO> createWarehouse(List<WarehouseDTO> createDTOS);
}
