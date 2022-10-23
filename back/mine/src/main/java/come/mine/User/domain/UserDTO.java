package come.mine.User.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component @Data
public class UserDTO {
    @ApiModelProperty(position = 1) private long userId;
    @ApiModelProperty(position = 2) String username;
    @ApiModelProperty(position = 3) String password;
    @ApiModelProperty(position = 4) String nickname;
    @ApiModelProperty(position = 5) String email;
    @ApiModelProperty(position = 6) String created_date;
    @ApiModelProperty(position = 7) String modified_date;
}
