package services.stock.request;

import services.stock.dto.RateDefinitionDTO;

import java.util.List;

public class CreateRatesRequest {
    private List<RateDefinitionDTO> createDTOS;

    public List<RateDefinitionDTO> getCreateDTOS() {
        return createDTOS;
    }

    public void setCreateDTOS(List<RateDefinitionDTO> createDTOS) {
        this.createDTOS = createDTOS;
    }
}
