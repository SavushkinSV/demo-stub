package ssv.home.demostub.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    @NotNull
    private String login;

    @NotNull
    private String password;

    private String date;

}
