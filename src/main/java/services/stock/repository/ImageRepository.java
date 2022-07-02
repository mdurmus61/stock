package services.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.stock.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findOneByCode(String code);
}
