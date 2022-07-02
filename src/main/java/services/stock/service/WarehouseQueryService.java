package services.stock.service;


import services.stock.dto.WarehouseDTO;

import java.util.List;

public interface WarehouseQueryService {

    List<WarehouseDTO> getWarehouseByCode(String code);

    List<WarehouseDTO> getAllWarehouses();

    List<WarehouseDTO> getAllWarehousesByDistrict(String district);

    List<WarehouseDTO> getAllWarehousesByCity(String city);
}
