package com.spring.mvc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    // 시큐리티 기본 설정 (권한처리, 초기로그인화면 없애기...)
    @Bean //라이브러리 클래스 같은 내가 만들지 않은 객체를 등록해서 주입받기 위한 이노테이션
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.csrf().disable() // 해커한테 CSRF 토큰 공격 방지 하기 위한 장치 해제

                //모든 요청에 대해서 인증을 하지 않겠다. (초기 로그인 화면을 없애겠다는 의미)
                //초기에 우리가 만들지 않은 로그인 화면 설정을 종료 하겠다.
                .authorizeRequests().antMatchers("/**").permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
