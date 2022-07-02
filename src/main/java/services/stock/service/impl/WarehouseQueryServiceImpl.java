package services.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.stock.dto.WarehouseDTO;
import services.stock.entity.Product;
import services.stock.entity.Warehouse;
import services.stock.repository.WarehouseRepository;
import services.stock.service.WarehouseQueryService;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class WarehouseQueryServiceImpl implements WarehouseQueryService {
    private final WarehouseRepository warehouseRepository;

    @Autowired
      public WarehouseQueryServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<WarehouseDTO> getWarehouseByCode(String code) {
        return Collections.singletonList(warehouseRepository.findOneByCode(code).toDTO());
    }

    @Override
    public List<WarehouseDTO> getAllWarehouses() {
        return warehouseRepository.findAll().stream().map(Warehouse::toDTO).collect(toList());
    }

    @Override
    public List<WarehouseDTO> getAllWarehousesByDistrict(String district) {
        return warehouseRepository.findAllByDistrictName(district).stream().map(Warehouse::toDTO).collect(toList());
    }

    @Override
    public List<WarehouseDTO> getAllWarehousesByCity(String city) {
        return warehouseRepository.findAllByDistrictCityName(city).stream().map(Warehouse::toDTO).collect(toList());
    }
}
