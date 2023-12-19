package com.spring.mvc.chap05.Controller;

import com.spring.mvc.chap05.common.PageMaker;
import com.spring.mvc.chap05.common.Search;
import com.spring.mvc.chap05.dto.response.BoardListResponseDTO;
import com.spring.mvc.chap05.dto.request.BoardWriteRequestDTO;
import com.spring.mvc.chap05.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoredController {

    private final BoardService boardService;
    //1.목록 조회 요청 (/board/list : GET)
    @GetMapping("list")
    public String list(@ModelAttribute("s") Search page, Model model){
        log.debug("page : {}, amount: {}",page.getPageNo(), page.getAmount());
        List<BoardListResponseDTO> dtoList = boardService.getList(page);

        //페이징 계산 알고리즘 적용

        PageMaker maker = new PageMaker(page, boardService.getCount(page));
        model.addAttribute("bList",dtoList);
        model.addAttribute("maker", maker);
//        model.addAttribute("s",page);

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
    public String detail(int bno,@ModelAttribute("s") Search search, Model model) {
        System.out.println("/board/detail : GET");
        model.addAttribute("b", boardService.getDetail(bno));
        return "chap05/detail";
    }
}
