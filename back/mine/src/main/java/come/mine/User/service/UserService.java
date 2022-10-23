package come.mine.User.service;

import come.mine.Auth.domain.Messenger;
import come.mine.User.domain.User;
import come.mine.User.domain.UserDTO;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {

    Messenger save(UserDTO userDTO);

    UserDTO login(UserDTO userDTO);

    Messenger logout(HttpServletRequest request);

    List<User> findAll();

    void delete(UserDTO userDTO) throws Exception;

    Messenger deleteAll();

    Messenger getOne(Long id);

    Messenger update(User user);

    void removeUser(String userId);

    public void findPw(HttpServletResponse response, UserDTO userDTO) throws Exception;
}
