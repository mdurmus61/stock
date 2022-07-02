package services.stock.service;

import services.stock.dto.RateDefinitionDTO;

import java.util.List;

public interface RateQueryService {
    List<RateDefinitionDTO> getRateByCode(String currencyCode);

    List<RateDefinitionDTO> getAllRates();
}
