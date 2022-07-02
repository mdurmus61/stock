package services.stock.entity;

import services.stock.dto.ProductDTO;
import services.stock.entity.base.BaseEntity;
import services.stock.repository.ImageRepository;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"type", "name"})})
public class Product extends BaseEntity {

    @NotNull
    private String type;

    @NotNull
    private String name;

    @NotNull
    @Digits(integer = 10, fraction = 9)
    private BigDecimal amount;

    @NotNull
    @OneToOne
    private Image image;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ProductDTO toDTO() {
        ProductDTO dto = new ProductDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setType(getType());
        dto.setAmount(getAmount());
        dto.setImage(getImage().toDTO());
        return dto;
    }

    public Product fromDTO(ProductDTO dto) {
        this.applyEntityStamps();
        setType(dto.getType());
        setAmount(dto.getAmount());
        setName(dto.getName());
        return this;
    }
}
