package ssv.home.demostub.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ssv.home.demostub.dto.ResponseDto;
import ssv.home.demostub.dto.UserDto;
import ssv.home.demostub.dto.UserStatusDto;
import ssv.home.demostub.util.RandomTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
public class StugController {

    @GetMapping
    public UserStatusDto getUser() {
//        log.info("GET");

        return new UserStatusDto("Login1", "Ok");
    }

    @PostMapping
    public ResponseDto postUser(@RequestBody UserDto user) throws InterruptedException {
//        log.info("POST");

        Thread.sleep(RandomTime.getRandomTime());
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return new ResponseDto(user.getLogin(), user.getPassword(), date);
    }
}
