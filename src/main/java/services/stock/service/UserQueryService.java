package services.stock.service;

import services.stock.dto.UserDTO;

import java.util.List;

public interface UserQueryService {
    List<UserDTO> getAllUsers();
}
