package services.stock.entity;

import services.stock.dto.WarehouseDTO;
import services.stock.entity.base.BaseEntity;
import services.stock.entity.metadata.District;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"code"})})
public class Warehouse extends BaseEntity {
    @NotNull
    private String address;

    @NotNull
    @ManyToOne
    private District district;

    @NotNull
    private String code;

    @NotNull
    private String name;

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public District getDistrict() { return district; }

    public void setDistrict(District district) { this.district = district; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public WarehouseDTO toDTO() {
        WarehouseDTO dto = new WarehouseDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setCode(getCode());
        dto.setAddress(getAddress());
        dto.setDistrict(getDistrict().getName());
        dto.setCity(getDistrict().getCity().getName());
        return dto;
    }

    public Warehouse fromDTO(WarehouseDTO dto) {
        this.applyEntityStamps();
        setAddress(dto.getAddress());
        setCode(dto.getCode());
        setName(dto.getName());
        return this;
    }
}
