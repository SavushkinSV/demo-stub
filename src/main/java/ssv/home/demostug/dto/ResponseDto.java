package ssv.home.demostug.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private String login;
    private String password;
    private String date;

    public ResponseDto(String login, String password, String date) {
        this.login = login;
        this.password = password;
        this.date = date;
    }
}
