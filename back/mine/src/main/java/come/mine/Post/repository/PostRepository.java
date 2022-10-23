package come.mine.Post.repository;

import come.mine.Post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Modifying
    @Query("update Post p set p.view = p.view + 1 where p.postId = :postId")
    int updateView(Long postId);
}
