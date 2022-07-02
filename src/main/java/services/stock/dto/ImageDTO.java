package services.stock.dto;

public class ImageDTO {
    private Long id;
    private String code;
    private byte[] image;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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
