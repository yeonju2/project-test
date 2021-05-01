package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private String comment;

    @Builder
    public PostsUpdateRequestDto(String title, String content, String comment) {
        this.title = title;
        this.content = content;
        this.comment = comment;
    }
}