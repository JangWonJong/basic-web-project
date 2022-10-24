package come.mine.Auth.services;

import come.mine.Auth.domain.Auth;
import come.mine.User.domain.User;
import come.mine.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName: {PACK}
 * fileName   : UserService
 * author     : Jangwonjong
 * date       : 2022-05-03
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-03     Jangwonjong       최초 생성
 */

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(()->new UsernameNotFoundException(username+"에 해당 사항이 없습니다."));
        return Auth.buld(user.get());
    }
}
