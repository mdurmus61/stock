package services.stock.service;


public interface ImageCommandService {
    String createImage(String code, byte[] contents);

    String updateImage(String code, byte[] contents);
}
