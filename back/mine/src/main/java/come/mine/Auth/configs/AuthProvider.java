package come.mine.Auth.configs;

import come.mine.Auth.services.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Component;

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
@Component
@RequiredArgsConstructor
@Log
public class AuthProvider implements AuthenticationProvider {

    private final AuthServiceImpl service;
}

