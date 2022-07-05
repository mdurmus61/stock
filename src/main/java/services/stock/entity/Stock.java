package services.stock.entity;

import services.stock.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"product_id", "warehouse_id"})})
public class Stock extends BaseEntity {
    @NotNull
    @ManyToOne
    private Product product;

    @NotNull
    @ManyToOne
    private Warehouse warehouse;

    @NotNull
    @Digits(integer = 16, fraction = 2)
    private BigDecimal quantity;

    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }

    public Warehouse getWarehouse() { return warehouse; }

    public void setWarehouse(Warehouse warehouse) { this.warehouse = warehouse; }

    public BigDecimal getQuantity() { return quantity; }

    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }
}
