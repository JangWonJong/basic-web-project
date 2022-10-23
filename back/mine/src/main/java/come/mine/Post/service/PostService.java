package come.mine.Post.service;

import come.mine.Auth.domain.Messenger;
import come.mine.Post.domain.Post;
import come.mine.Post.domain.PostDTO;

import java.util.Optional;

public interface PostService {
    int updateView(Long id);

    Optional<Post> findById(Long id);

    Messenger save(PostDTO.Request dto, String nickname);
}
