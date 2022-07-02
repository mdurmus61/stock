package services.stock.service;

import services.stock.dto.RateDefinitionDTO;

import java.util.List;

public interface RateCommandService {
    List<RateDefinitionDTO> createRates(List<RateDefinitionDTO> createDTOS);

    List<RateDefinitionDTO> updateRates(List<RateDefinitionDTO> createDTOS);

}
