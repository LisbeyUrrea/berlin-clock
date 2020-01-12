package mocks;

public class UserManager {

    private String name;
    private String lastName;
    private String email;
    private String mobile;
    private String password;
    private String nickname;

    public UserManager(String name, String lastName, String email, String mobile, String password, String nickname) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }
}
