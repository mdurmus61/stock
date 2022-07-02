package services.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.stock.dto.RateDefinitionDTO;
import services.stock.entity.metadata.RateDefinition;
import services.stock.repository.metadata.RateDefinitionRepository;
import services.stock.service.RateCommandService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RateCommandServiceImpl implements RateCommandService {
    private final RateDefinitionRepository rateDefinitionRepository;

    @Autowired
    public RateCommandServiceImpl(RateDefinitionRepository rateDefinitionRepository) {
        this.rateDefinitionRepository = rateDefinitionRepository;
    }

    @Override
    public List<RateDefinitionDTO> createRates(List<RateDefinitionDTO> createDTOS) {
        List<RateDefinitionDTO> list = new ArrayList<>();
        for(RateDefinitionDTO dto: createDTOS)
            list.add(rateDefinitionRepository.save(new RateDefinition().fromDTO(dto)).toDTO());

        return list;
    }

    @Override
    public List<RateDefinitionDTO> updateRates(List<RateDefinitionDTO> createDTOS) {
        List<RateDefinitionDTO> list = new ArrayList<>();
        for(RateDefinitionDTO dto: createDTOS) {
            RateDefinition rateDefinition = rateDefinitionRepository.findOneByCurrencyCode(dto.getCurrencyCode());
            rateDefinition.applyEntityStamps();
            rateDefinition.setRate(dto.getRate());
            list.add(rateDefinitionRepository.save(rateDefinition).toDTO());
        }

        return list;
    }
}
