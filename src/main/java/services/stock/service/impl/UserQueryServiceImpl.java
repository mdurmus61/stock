package services.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.stock.dto.UserDTO;
import services.stock.entity.User;
import services.stock.repository.UserRepository;
import services.stock.service.UserQueryService;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    @Autowired
    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(User::toDTO).collect(toList());
    }
}
