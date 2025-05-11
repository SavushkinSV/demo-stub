package ssv.home.demostub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto {

    @NotBlank
    private String login;

    @NotNull
    @Pattern(regexp = ".{8,}")
    private String password;

    private String date;

}
