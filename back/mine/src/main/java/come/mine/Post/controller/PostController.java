package come.mine.Post.controller;

import come.mine.Post.domain.PostDTO;
import come.mine.Post.service.PostService;
import come.mine.User.domain.UserDTO;
import io.swagger.models.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("board/")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity save(@RequestBody PostDTO.Request postDTO, UserDTO userDTO){
        return ResponseEntity.ok(postService.save(postDTO, userDTO.getNickname()));
    }

}
