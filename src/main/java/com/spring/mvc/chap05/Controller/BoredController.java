package com.spring.mvc.chap05.Controller;

import com.spring.mvc.chap05.dto.BoardListResponseDTO;
import com.spring.mvc.chap05.dto.BoardWriteRequestDTO;
import com.spring.mvc.chap05.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoredController {

    private final BoardService boardService;
    //1.목록 조회 요청 (/board/list : GET)
    @GetMapping("list")
    public String list(Model model){
        List<BoardListResponseDTO> dtoList = boardService.getList();
        model.addAttribute("bList",dtoList);
        return "chap05/list";
    }


    //2. 글쓰기 화면요청 (/board/write : GET)
    @GetMapping("/write")
    public String write(){
        return "chap05/write";
    }
    //3. 글쓰기 등록 요청 (/board/write : POST);
    @PostMapping("/write")
    public String write (BoardWriteRequestDTO dto){
        boardService.register(dto);
        return "redirect:/board/list";

    }
    //4. 글삭제 요청 (/board/delete : GET)
    @GetMapping("/delete")
    public String delete(int bno) {
        System.out.println("/board/delete : GET");
        boardService.delete(bno);
        return "redirect:/board/list";
    }
    //5 글 상세 보기 요청(/board/detail : GET)
    @GetMapping("/detail")
    public String detail(int bno, Model model) {
        System.out.println("/board/detail : GET");
        model.addAttribute("b", boardService.getDetail(bno));
        return "chap05/detail";
    }
}
