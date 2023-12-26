package com.spring.mvc.chap05.dto.request;

import com.spring.mvc.chap05.entify.Member;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SignUpRequestDTO {

    @NotBlank
    @Size(min =4, max =14)
    private String account;
    @NotBlank
    private String password;
    @NotBlank
    @Size (min = 2, max = 6)
    private String name;
    @NotBlank
    @Email
    private String email;

    //엔터티로 변환하는 유틸메서드
    public Member toEntity(PasswordEncoder encoder){
        return Member.builder()
                .account(account)
                .password(encoder.encode(password))
                .email(email)
                .name(name)
                .build();

    }
}
