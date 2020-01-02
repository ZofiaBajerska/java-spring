package spring_homework.homework.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NamedQuery(name = "User.findByTheUsersName", query = "from User u where u.username = ?1" )
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(unique = true)
    private String username;

    private String password;
    private boolean is_admin;
    private Integer login_count;
    private Timestamp last_login;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public Integer getLogin_count() {
        return login_count;
    }

    public void setLogin_count(Integer login_count) {
        this.login_count = login_count;
    }

    public Timestamp getLast_login() {
        return last_login;
    }

    public void setLast_login(Timestamp last_login) {
        this.last_login = last_login;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", is_admin='").append(is_admin).append('\'');
        sb.append(", login_count=").append(login_count).append('\'');
        sb.append(", last_login=").append(last_login).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
