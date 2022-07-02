package services.stock.repository.metadata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.stock.entity.metadata.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);
}
