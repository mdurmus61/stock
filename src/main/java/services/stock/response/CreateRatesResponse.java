package services.stock.response;

import services.stock.dto.RateDefinitionDTO;
import services.stock.dto.UserDTO;
import services.stock.response.base.BaseApiResponse;

import java.util.List;

public class CreateRatesResponse extends BaseApiResponse {
    private List<RateDefinitionDTO> retValues;

    public CreateRatesResponse(String key, List<RateDefinitionDTO> retValues) {
        super(key, true);
        this.retValues = retValues;
    }

    public List<RateDefinitionDTO> getRetValues(){
        return retValues;
    }

    public void setRetValues(List<RateDefinitionDTO> retValues) {
        this.retValues = retValues;
    }
}
