package services.stock.dto;

import services.stock.dto.base.BaseDTO;

public class WarehouseDTO extends BaseDTO {
    private String address;
    private String district;
    private String city;
    private String code;
    private String name;

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getDistrict() { return district; }

    public void setDistrict(String district) { this.district = district; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
