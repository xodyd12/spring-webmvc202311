package com.spring.mvc.chap05.entify;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Auth {
    COMMON("일반회원",1)
    , ADMIN("관리자 회원",2);




    private String description; //권한 설명
    private int authNumber; //권한번호
}
