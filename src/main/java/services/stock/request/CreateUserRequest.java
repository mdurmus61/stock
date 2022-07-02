package services.stock.request;

import services.stock.dto.UserDTO;

public class CreateUserRequest {
    private UserDTO createDTO;

    public UserDTO getCreateDTO() { return createDTO; }

    public void setCreateDTO(UserDTO createDTO) { this.createDTO = createDTO; }
}
