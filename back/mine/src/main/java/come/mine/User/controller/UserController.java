package come.mine.User.controller;

import come.mine.Auth.domain.Messenger;
import come.mine.User.domain.UserDTO;
import come.mine.User.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "user")
@RestController
@RequestMapping("user/")
@RequiredArgsConstructor
public class UserController {
    public final UserService service;

    @PostMapping("/join")
    public ResponseEntity<Messenger> save(@ApiParam("Join User") @RequestBody UserDTO userDTO){
        System.out.println("회원가입 정보:" + userDTO.toString());
        return ResponseEntity.ok(service.save(userDTO));
    }
}
