package ssv.home.demostug.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String login;
    private String password;
    private String status;

    public User(String login, String status) {
        this.login = login;
        this.status = status;
    }


}
