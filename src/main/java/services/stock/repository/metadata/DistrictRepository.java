package services.stock.repository.metadata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.stock.entity.metadata.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
    District findByNameAndCityName(String name, String cityName);
}
