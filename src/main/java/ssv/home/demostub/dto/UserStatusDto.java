package ssv.home.demostub.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserStatusDto {

    private String login;

    private String status;

    public UserStatusDto(String login, String status) {
        this.login = login;
        this.status = status;
    }
}
