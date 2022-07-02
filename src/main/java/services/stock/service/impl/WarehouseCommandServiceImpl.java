package services.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.stock.dto.WarehouseDTO;
import services.stock.entity.Warehouse;
import services.stock.entity.metadata.District;
import services.stock.repository.WarehouseRepository;
import services.stock.repository.metadata.DistrictRepository;
import services.stock.service.WarehouseCommandService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WarehouseCommandServiceImpl implements WarehouseCommandService {
    private final WarehouseRepository warehouseRepository;
    private final DistrictRepository districtRepository;

    @Autowired
      public WarehouseCommandServiceImpl(WarehouseRepository warehouseRepository, DistrictRepository districtRepository) {
        this.warehouseRepository = warehouseRepository;
        this.districtRepository = districtRepository;
    }

    @Override
    public List<WarehouseDTO> createWarehouse(List<WarehouseDTO> createDTOS) {
        List<WarehouseDTO> list = new ArrayList<>();
        for(WarehouseDTO dto: createDTOS) {
            District district = districtRepository.findByNameAndCityName(dto.getDistrict(), dto.getCity());
            Warehouse warehouse = new Warehouse().fromDTO(dto);
            warehouse.setDistrict(district);
            list.add(warehouseRepository.save(warehouse).toDTO());
        }

        return list;
    }
}
