package services.stock.entity.metadata;

import services.stock.dto.RateDefinitionDTO;
import services.stock.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"currencyCode"})})
public class RateDefinition extends BaseEntity {

    @NotNull
    private String currencyCode;

    @NotNull
    @Digits(integer = 10, fraction = 9)
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

    public RateDefinitionDTO toDTO() {
        RateDefinitionDTO dto = new RateDefinitionDTO();
        dto.setId(getId());
        dto.setCurrencyCode(getCurrencyCode());
        dto.setRate(getRate());

        return dto;
    }

    public RateDefinition fromDTO(RateDefinitionDTO dto) {
        this.applyEntityStamps();
        setCurrencyCode(dto.getCurrencyCode());
        setRate(dto.getRate());
        return this;
    }
}
