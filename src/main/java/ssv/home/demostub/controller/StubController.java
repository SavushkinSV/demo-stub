package ssv.home.demostub.controller;

import org.springframework.web.bind.annotation.*;
import ssv.home.demostub.dto.ResponseDto;
import ssv.home.demostub.dto.UserDto;
import ssv.home.demostub.dto.UserStatusDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class StubController {

    private static final Random random = new Random();

    @GetMapping()
    public UserStatusDto getUser() {
        try {
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new UserStatusDto("Login1", "Ok");
    }

    @PostMapping()
    public ResponseDto postUser(@RequestBody UserDto user) {
        try {
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return new ResponseDto(user.getLogin(), user.getPassword(), date);
    }
}
