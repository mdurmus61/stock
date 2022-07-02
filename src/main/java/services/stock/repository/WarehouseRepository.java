package services.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.stock.entity.Warehouse;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Warehouse findOneByCode(String code);
    List<Warehouse> findAllByDistrictName(String district);
    List<Warehouse> findAllByDistrictCityName(String city);
}
