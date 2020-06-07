package spring.intro.dto;

import spring.intro.model.User;

public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private String password;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserResponseDto{"
                + "id=" + id
                + ", name=" + name
                + ", email='" + email + '\''
                + '}';
    }
}
