package services.stock.entity;

import services.stock.dto.UserDTO;
import services.stock.entity.base.BaseEntity;
import services.stock.util.PasswordUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"userName"})})
public class User extends BaseEntity {

    @NotNull
    private String userName;

    @NotNull
    private String email;

    private String phoneNumber;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public UserDTO toDTO() {
        UserDTO dto = new UserDTO();
        dto.setId(getId());
        dto.setUserName(getUserName());
        dto.setFirstName(getFirstName());
        dto.setLastName(getLastName());
        dto.setEmail(getEmail());
        dto.setPhoneNumber(getPhoneNumber());
        dto.setRoles(getRoles().stream().map(Role::getName).collect(toSet()));
        dto.setPassword(PasswordUtil.decrypt(getPassword()));
        return dto;
    }

    public User fromDTO(UserDTO dto) {
        this.applyEntityStamps();
        setUserName(dto.getUserName());
        setFirstName(dto.getFirstName());
        setLastName(dto.getLastName());
        setEmail(dto.getEmail());
        setPhoneNumber(dto.getPhoneNumber());
        setPassword(PasswordUtil.encrypt(dto.getPassword()));
        return this;
    }
}
