package ssv.home.demostug.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private String login;
    private String password;
    private String date;

    public Response(String login, String password, String date) {
        this.login = login;
        this.password = password;
        this.date = date;
    }
}
