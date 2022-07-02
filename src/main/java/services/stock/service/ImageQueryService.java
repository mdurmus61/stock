package services.stock.service;

import services.stock.dto.ImageDTO;

public interface ImageQueryService {
    ImageDTO getImageByCode(String code);
}
