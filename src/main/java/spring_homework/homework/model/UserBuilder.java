package spring_homework.homework.model;

import java.sql.Timestamp;

public class UserBuilder {
    private String id;
    private String username;
    private String password;
    private boolean is_admin;
    private Integer login_count;
    private Timestamp last_login;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withIsAdmin(boolean is_admin) {
        this.is_admin = is_admin;
        return this;
    }

    public UserBuilder withLoginCount(Integer login_count) {
        this.login_count = login_count;
        return this;
    }

    public UserBuilder withLastLogin(Timestamp last_login) {
        this.last_login = last_login;
        return this;
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setIs_admin(is_admin);
        user.setLogin_count(login_count);
        user.setLast_login(last_login);

        return user;
    }

}
