package ssv.home.demostub.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssv.home.demostub.dto.LoginDto;
import ssv.home.demostub.dto.LoginStatusDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class StubController {

    private static final Random random = new Random();

    @GetMapping()
    public ResponseEntity<?> getLogin() {
        try {
            Thread.sleep(getDelayTime());
        } catch (InterruptedException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LoginStatusDto dto = new LoginStatusDto("Login1", "Ok");

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> postUser(@Valid @RequestBody LoginDto dto) {
        try {
            Thread.sleep(getDelayTime());
        } catch (InterruptedException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        dto.setDate(currentDate);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    private static int getDelayTime() {
        return 1000 + random.nextInt(1000);
    }

}
