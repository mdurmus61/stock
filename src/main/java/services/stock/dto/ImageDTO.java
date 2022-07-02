package services.stock.dto;

import services.stock.dto.base.BaseDTO;

public class ImageDTO extends BaseDTO {
    private String code;
    private byte[] image;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
