package come.mine.Auth.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Messenger {
    private String message, code;
    private int status;
}
