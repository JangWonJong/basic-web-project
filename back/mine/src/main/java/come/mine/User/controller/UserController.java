package come.mine.User.controller;

import come.mine.Auth.domain.Messenger;
import come.mine.User.domain.User;
import come.mine.User.domain.UserDTO;
import come.mine.User.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@ApiParam("Login User")@RequestBody UserDTO userDTO){
        System.out.println("로그인 정보:"+ userDTO.getUsername());
        return ResponseEntity.ok(service.login(userDTO));
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<Messenger> logout(HttpServletRequest request){
        return ResponseEntity.ok(service.logout(request));
    }

    @PutMapping("/update")
    public ResponseEntity<Messenger> update(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(service.update(userDTO));
    }

    @DeleteMapping("/deleteAll")
    public Messenger deleteAll(){
        System.out.println("삭제완료");
        return service.deleteAll();
    }

    @DeleteMapping("/delete") @ResponseBody
    public void delete(@RequestBody UserDTO userDTO) throws Exception{
        service.delete(userDTO);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}

