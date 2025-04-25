package ssv.home.demostub.controller;

import org.springframework.web.bind.annotation.*;
import ssv.home.demostub.dto.ResponseDto;
import ssv.home.demostub.dto.UserDto;
import ssv.home.demostub.dto.UserStatusDto;
import ssv.home.demostub.util.RandomTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/user")
public class StubController {

    @GetMapping()
    public UserStatusDto getUser() {

        return new UserStatusDto("Login1", "Ok");
    }

    @PostMapping()
    public ResponseDto postUser(@RequestBody UserDto user) throws InterruptedException {
        Thread.sleep(RandomTime.getRandomTime());
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return new ResponseDto(user.getLogin(), user.getPassword(), date);
    }
}
