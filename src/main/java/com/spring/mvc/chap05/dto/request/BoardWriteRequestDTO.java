package com.spring.mvc.chap05.dto.request;

import lombok.*;
@Getter @Setter
@ToString @EqualsAndHashCode
@NoArgsConstructor
public class BoardWriteRequestDTO {

    private String title;
    private String content;
}
