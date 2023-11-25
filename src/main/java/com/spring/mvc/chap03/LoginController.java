package com.spring.mvc.chap03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Login")
public class LoginController {
    @GetMapping("inputLogin")
    public String inputLogin(){
        return "chap03/s-form";
    }
    /*
        1번요청: 로그인 폼 화면 열어주기
        - 요청 URL : /hw/s-login-form : GET
        - 포워딩 jsp파일 경로:  /WEB-INF/views/chap03/s-form.jsp
        - html form: 아이디랑 비번을 입력받으세요.



        2번요청: 로그인 검증하기
        - 로그인 검증: 아이디를 grape111이라고 쓰고 비번을 ggg9999 라고 쓰면 성공
        - 요청 URL : /hw/s-login-check : POST
        - 포워딩 jsp파일 경로:  /WEB-INF/views/chap03/s-result.jsp
        - jsp에게 전달할 데이터: 로그인 성공여부, 아이디 없는경우, 비번 틀린경우

     */

    @PostMapping("/Login")
    public String Login(String id, String password, Model model){
        System.out.println("id = " + id);
        System.out.println("password = " + password);

        if("grape111".equals(id) && "ggg9999".equals(password)) {
            //2. 내가 입력한거 jsp 에게 전달하기
            model.addAttribute("id", id);
            model.addAttribute("password", password);
            model.addAttribute("LoginResult","로그인 성공");
        }else if("grape111".equals(id) && ! "ggg9999".equals(password)){
            model.addAttribute("id",id);
            model.addAttribute("password",password);
            model.addAttribute("LoginResult","비밀번호를 고쳐쓰세요!");
        }else if(!"grape111".equals(id) && "ggg9999".equals(password)){
            model.addAttribute("id",id);
            model.addAttribute("password",password);
            model.addAttribute("LoginResult","아이디를 고쳐쓰세요!");
        }else{
            model.addAttribute("id",id);
            model.addAttribute("password",password);
            model.addAttribute("LoginResult","로그인 실패! 아이디와 비밀번호를 다시 확인 해주세요!");
        }
        return "chap03/s-result";

    }
}
