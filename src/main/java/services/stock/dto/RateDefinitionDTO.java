package services.stock.dto;

import services.stock.dto.base.BaseDTO;

import java.math.BigDecimal;

public class RateDefinitionDTO extends BaseDTO {
    private String currencyCode;
    private BigDecimal rate;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
