package come.mine.User.service;


import come.mine.Auth.domain.Messenger;
import come.mine.Auth.exception.SecurityRuntimeException;
import come.mine.User.domain.User;
import come.mine.User.domain.UserDTO;
import come.mine.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final ModelMapper modelMapper;

    @Override
    public Messenger save(UserDTO userDTO) {
        System.out.println("전달된 정보:" + userDTO.toString());
        String result = "";
        if (userRepository.findByUsername(userDTO.getUsername()).isEmpty()) {
            userRepository.save(User.builder()
                    .username(userDTO.getUsername())
                    .nickname(userDTO.getNickname())
                    .password(userDTO.getPassword())
                    .email(userDTO.getEmail()).build());
            result = "SUCCESS";
        }else {
            result = "FAIL";
        }
        return Messenger.builder().message(result).build();
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        try {
            UserDTO returnUser = new UserDTO();
            String username = userDTO.getUsername();
            User findUser = userRepository.findByUsername(username).orElse(null);
            if (findUser != null){
                boolean checkPassword = encoder.matches(userDTO.getPassword(), findUser.getPassword());
                if(checkPassword){
                    returnUser = modelMapper.map(findUser, UserDTO.class);
                    findUser = modelMapper.map(returnUser, User.class);
                }else {
                    String token = "FAILURE";
                }
            }else {
            }
            return returnUser;
        }catch (Exception e){
            throw new SecurityRuntimeException("유효하지 않은 아이디/비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public Messenger logout(HttpServletRequest request) {
        log.info("logout Method 진입");
        HttpSession session = request.getSession();
        session.invalidate();
        return Messenger.builder().message("로그아웃 완료").build();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(UserDTO userDTO) throws Exception {
        User user = userRepository.findByUsername(userDTO.getUsername()).orElse(null);
        userRepository.delete(user);

    }

    @Override
    public Messenger deleteAll() {
        return null;
    }

    @Override
    public Messenger getOne(Long id) {
        return null;
    }

    @Override
    public Messenger update(User user) {
        final Optional<User> original = userRepository.findById(user.getUserId());
        original.ifPresent(user1 -> {
            User.builder().userId(user.getUserId())
                    .username(user.getUsername())
                    .nickname(user.getNickname())
                    .password(user.getPassword())
                    .email(user.getEmail())
                    .build();
            userRepository.save(user1);
        });

        return Messenger.builder().message("업데이트 완료").build();
    }

    @Override
    public void removeUser(String userId) {

    }

    @Override
    public void findPw(HttpServletResponse response, UserDTO userDTO) throws Exception {

    }
}
