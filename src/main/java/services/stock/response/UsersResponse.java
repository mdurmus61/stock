package services.stock.response;


import services.stock.dto.UserDTO;
import services.stock.response.base.BaseApiResponse;

import java.util.ArrayList;
import java.util.List;

public class UsersResponse extends BaseApiResponse {
    private List<UserDTO> users = new ArrayList<>();

    public UsersResponse(String key, List<UserDTO> users) {
        super(key, true);
        this.users = users;
    }

    public List<UserDTO> getUsers() { return users; }

    public void setUsers(List<UserDTO> users) { this.users = users; }
}
