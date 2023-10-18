package com.example.back_end.Controller;



import com.example.back_end.Service.UserService;
import com.example.back_end.dto.User.UserJoinDto;
import com.example.back_end.dto.User.UserLoginDto;
import com.example.back_end.vo.User.UserJoinVo;
import com.example.back_end.vo.User.UserLoginVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class UserController {

    private final UserService userService;


    @PostMapping("/join")
    public ResponseEntity<Object> join(@RequestBody UserJoinDto request) {
        return ResponseEntity.ok().body(UserJoinVo.fromUser(userService.join(request.getName(), request.getPassword())));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDto request) {
        String token = userService.login(request.getName(), request.getPassword());
        return ResponseEntity.ok().body(new UserLoginVo(token));
    }

    @GetMapping("/profile")
    public ResponseEntity<Object> profile(@RequestHeader(value="Authorization") String token) {
        System.out.println(token);
        return ResponseEntity.ok().body(userService.profile(token));
    }

}
