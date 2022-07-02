package services.stock.response;


import services.stock.dto.ImageDTO;
import services.stock.response.base.BaseApiResponse;

public class ImageResponse extends BaseApiResponse {
    private ImageDTO image;

    public ImageResponse(String key, ImageDTO image) {
        super(key, true);
        this.image = image;
    }

    public ImageDTO getImage() { return image; }

    public void setImage(ImageDTO image) { this.image = image; }
}
