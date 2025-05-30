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
public class UserController {

    private static final Random random = new Random();

    @GetMapping()
    public ResponseEntity<?> status() {
        getDelay();
        LoginStatusDto dto = new LoginStatusDto("Login1", "Ok");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> add(@Valid @RequestBody LoginDto dto) {
        getDelay();
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        dto.setDate(currentDate);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    private static void getDelay() {
        try {
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
