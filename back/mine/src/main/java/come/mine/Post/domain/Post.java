package come.mine.Post.domain;


import com.sun.istack.NotNull;
import come.mine.User.domain.User;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "posts")
public class Post extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;
    @Column(length = 500)
    private @NotNull String title;
    @Column(columnDefinition = "TEXT")
    private @NotNull String contents;
    @Column
    private String writer;
    @Column(columnDefinition = "integer default 0")
    private int view;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;
}
