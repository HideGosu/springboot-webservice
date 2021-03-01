package org.example.springboot_webservice.service.posts;

import lombok.RequiredArgsConstructor;
import org.example.springboot_webservice.web.domain.posts.Posts;
import org.example.springboot_webservice.web.domain.posts.PostsRepository;
import org.example.springboot_webservice.web.dto.PostsResponseDto;
import org.example.springboot_webservice.web.dto.PostsSaveRequestDto;
import org.example.springboot_webservice.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. ID=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. ID=" + id));

        return new PostsResponseDto(entity);
    }
}
