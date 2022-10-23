package come.mine.Post.service;

import come.mine.Auth.domain.Messenger;
import come.mine.Post.domain.Post;
import come.mine.Post.domain.PostDTO;
import come.mine.Post.repository.PostRepository;
import come.mine.User.domain.User;
import come.mine.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    public final PostRepository postRepository;
    public final UserRepository userRepository;
    @Override
    public int updateView(Long id) {
        return postRepository.updateView(id);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Messenger save(PostDTO.Request dto, String nickname) {
        System.out.println("전달된 정보:" + dto.toString());
        String result = "";
            postRepository.save(Post.builder()
                            .title(dto.getTitle())
                            .contents(dto.getContents())
                    .build());
            result = "SUCCESS";

        return Messenger.builder().message(result).build();
    }
}
