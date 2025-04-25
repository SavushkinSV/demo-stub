package ssv.home.demostub.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String login;
    private String password;

    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
