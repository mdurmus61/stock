package services.stock.dto;

import services.stock.entity.Role;

import java.util.Set;

public class UserDTO {
    private Long id;
    private String userName;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String password;
    private String token;
    private Set<String> roles;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }

    public Set<String> getRoles() { return roles; }

    public void setRoles(Set<String> roles) { this.roles = roles; }
}
