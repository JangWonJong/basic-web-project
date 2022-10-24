package come.mine.User.domain;

import com.sun.istack.NotNull;
import come.mine.Post.domain.TimeEntity;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity @Eager
@Getter
@Setter
@Table(name = "users")
public class User extends TimeEntity{
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column private @NotNull String username;
    @Column private @NotNull String password;
    @Column private @NotNull String nickname;
    @Column private @NotNull String email;


}
