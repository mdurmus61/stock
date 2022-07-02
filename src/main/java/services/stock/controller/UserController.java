package services.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import services.stock.controller.constants.ApiEndpoints;
import services.stock.request.CreateUserRequest;
import services.stock.response.UserResponse;
import services.stock.response.UsersResponse;
import services.stock.service.UserCommandService;
import services.stock.service.UserQueryService;
import services.stock.util.IdGenerator;
import services.stock.util.JwtUtils;

import javax.validation.Valid;

@RestController
@RequestMapping(value = ApiEndpoints.USER_API, produces = { ApiEndpoints.RESPONSE_CONTENT_TYPE}, consumes = {
        MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class UserController {
    private final IdGenerator idGenerator;
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @Autowired
    public UserController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.idGenerator = new IdGenerator(0);
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping("/create")
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest request) {
        return new UserResponse(idGenerator.getString(), userCommandService.createUser(request.getCreateDTO()));
    }

    @PostMapping("/update")
    public UserResponse updateUser(@Valid @RequestBody CreateUserRequest request) {
        return new UserResponse(idGenerator.getString(), userCommandService.updateUser(request.getCreateDTO()));
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse login(@Valid @RequestBody CreateUserRequest request) {
        return new UserResponse(idGenerator.getString(), userCommandService.login(request.getCreateDTO()));
    }

    @GetMapping(value = "/get/all", consumes = MediaType.ALL_VALUE)
    public UsersResponse getAllUsers(){
        return new UsersResponse(idGenerator.getString(), userQueryService.getAllUsers());
    }
}
