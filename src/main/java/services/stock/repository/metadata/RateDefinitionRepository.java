package services.stock.repository.metadata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.stock.entity.metadata.RateDefinition;

@Repository
public interface RateDefinitionRepository extends JpaRepository<RateDefinition, Long> {
    RateDefinition findOneByCurrencyCode(String currencyCode);
}
