package com.practiceseries.demo7.payload;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String name;
    private String body;
    private String email;

}
