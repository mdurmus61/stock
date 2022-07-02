package services.stock.response;


import services.stock.dto.UserDTO;
import services.stock.response.base.BaseApiResponse;

public class UserResponse extends BaseApiResponse {
    private UserDTO user;

    public UserResponse(String key, UserDTO user) {
        super(key, true);
        this.user = user;
    }

    public UserDTO getUser() { return user; }

    public void setUser(UserDTO user) { this.user = user; }
}
