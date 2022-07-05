package services.stock.service.impl;

import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import services.stock.dto.UserDTO;
import services.stock.entity.User;
import services.stock.entity.metadata.Role;
import services.stock.exception.StockException;
import services.stock.repository.metadata.RoleRepository;
import services.stock.repository.UserRepository;
import services.stock.service.UserCommandService;
import services.stock.util.PasswordUtil;
import services.stock.util.JwtUtils;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserCommandServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDTO createUser(UserDTO createDTO) {
        Set<Role> roles = roleRepository.findAllByNameIn(createDTO.getRoles());
        User user = new User().fromDTO(createDTO);
        user.setRoles(roles);
        user = userRepository.save(user);
        return user.toDTO();
    }

    @Override
    public UserDTO updateUser(UserDTO dto) {
        User user = userRepository.findByUserName(dto.getUserName()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with userName: " + dto.getUserName()));
        user.applyEntityStamps();
        if(!StringUtils.isNullOrEmpty(dto.getPassword())) user.setPassword(PasswordUtil.encrypt(dto.getPassword()));
        if(!StringUtils.isNullOrEmpty(dto.getPhoneNumber())) user.setPhoneNumber(dto.getPhoneNumber());
        if(!StringUtils.isNullOrEmpty(dto.getEmail())) user.setEmail(dto.getEmail());
        user = userRepository.save(user);

        return user.toDTO();
    }

    @Override
    public UserDTO login(String username, String password) {
        User user = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with userName: " + username));
        if(!password.equals(PasswordUtil.decrypt(user.getPassword())))
            throw new StockException("LOGIN", "LOGIN", "password incorrect : " + password);

        String token = JwtUtils.getJWTToken(user.getId(), user.getUserName(), password, user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
        UserDTO userDTO = user.toDTO();
        userDTO.setToken(token);
        return userDTO;
    }


}
