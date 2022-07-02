package services.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.stock.entity.RateDefinition;

@Repository
public interface RateDefinitionRepository extends JpaRepository<RateDefinition, Long> {
    RateDefinition findOneByCurrencyCode(String currencyCode);
}
