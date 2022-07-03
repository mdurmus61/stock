package services.stock.service;

import services.stock.dto.UserDTO;

public interface UserCommandService {
    UserDTO createUser(UserDTO createDTO);

    UserDTO updateUser(UserDTO createDTO);

    UserDTO login(String username, String password);
}
