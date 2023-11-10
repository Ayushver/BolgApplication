package com.practiceseries.demo7.payload;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDetails99 {
    private Date timestamp;
    private String message;
    private String details;
}
