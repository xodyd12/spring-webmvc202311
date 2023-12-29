package com.spring.mvc.interceptor;

import com.spring.mvc.util.LoginUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
@Slf4j
public class AfterLoginInterceptor implements HandlerInterceptor {

    // 로그인 한 이후 비 회원만 접근 할 수 있는 페이지 접근 차단

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {


        log.info("ater login interceptor execute!!");
        HttpSession session = request.getSession();

        if(LoginUtils.isLogin(session)){
            response.sendRedirect("/");
            return false; // 로그인 했잖아 ~ 나가
        }
        return true; // 로그인 안했네 ? 들어와 ~
    }
}
