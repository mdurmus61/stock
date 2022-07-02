package services.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.stock.dto.RateDefinitionDTO;
import services.stock.entity.RateDefinition;
import services.stock.repository.RateDefinitionRepository;
import services.stock.service.RateQueryService;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class RateQueryServiceImpl implements RateQueryService {
    private final RateDefinitionRepository rateDefinitionRepository;

    @Autowired
    public RateQueryServiceImpl(RateDefinitionRepository rateDefinitionRepository) {
        this.rateDefinitionRepository = rateDefinitionRepository;
    }


    @Override
    public List<RateDefinitionDTO> getRateByCode(String currencyCode) {
        return Collections.singletonList(rateDefinitionRepository.findOneByCurrencyCode(currencyCode).toDTO());
    }

    @Override
    public List<RateDefinitionDTO> getAllRates() {
        return rateDefinitionRepository.findAll().stream().map(RateDefinition::toDTO).collect(toList());
    }
}
