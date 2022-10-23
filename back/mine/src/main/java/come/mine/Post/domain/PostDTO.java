package come.mine.Post.domain;

import come.mine.User.domain.User;
import lombok.*;

public class PostDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{

        private Long id;
        private String title;
        private String writer;
        private String contents;
        private String createdDate, modifiedDate;
        private int view;
        private User user;

        public Post toEntity(){
            Post post = Post.builder()
                    .postId(id)
                    .title(title)
                    .writer(writer)
                    .contents(contents)
                    .view(0)
                    .user(user)
                    .build();
            return post;
        }
    }
    @Getter
    public static class Response{
        private final Long id;
        private final String title;
        private final String writer;
        private final String contents;
        private final String createdDate, modifiedDate;
        private final int view;
        private final Long userId;

        public Response(Post post){
            this.id = post.getPostId();
            this.title = post.getTitle();
            this.writer = post.getWriter();
            this.contents = post.getContents();
            this.createdDate = post.getCreatedDate();
            this.modifiedDate = post.getModifiedDate();
            this.view = post.getView();
            this.userId = post.getUser().getUserId();


        }

    }

}
