package com.spring.mvc.interceptor;

import com.spring.mvc.chap05.entify.Member;
import com.spring.mvc.chap05.repository.MemberMapper;
import com.spring.mvc.chap05.service.MemberSerivce;
import com.spring.mvc.chap05.service.MemberSerivce;
import com.spring.mvc.util.LoginUtils;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class AutoLoginInterceptor implements HandlerInterceptor {

    private final MemberMapper memberMapper;
    private final MemberSerivce memberSerivce;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 사이트에 들어오면 자동로그인 쿠키를 가진 클라이언트 인지 체크
        Cookie autoLoginCookie = WebUtils.getCookie(request, LoginUtils.AUTO_LOGIN_COOKIE);

        //2. 자동로그인 쿠키가 있다면 로그인 처리를 수행
        if(autoLoginCookie != null){

            //3. 지금 읽은 쿠키에 들어있는 session_id를 확인
            String sessionId = autoLoginCookie.getValue();

            //4. DB에서 쿠키에 들어있는 세션아이디를 가진 회원을 조회
           Member member = memberMapper.findMemberByCookie(sessionId);

           if (member != null && LocalDateTime.now().isBefore(member.getLimitTime())){
               memberSerivce.maintainLoginState(request.getSession(), member.getAccount());
           }


        }
        return true;
    }
}
