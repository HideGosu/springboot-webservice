package org.example.springboot_webservice.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot_webservice.service.posts.PostsService;
import org.example.springboot_webservice.web.dto.PostsResponseDto;
import org.example.springboot_webservice.web.dto.PostsSaveRequestDto;
import org.example.springboot_webservice.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody
                       PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}
