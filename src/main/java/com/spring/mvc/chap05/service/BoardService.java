package com.spring.mvc.chap05.service;

import com.spring.mvc.chap05.common.Search;
import com.spring.mvc.chap05.dto.response.BoardDetailResponseDTO;
import com.spring.mvc.chap05.dto.response.BoardListResponseDTO;
import com.spring.mvc.chap05.dto.request.BoardWriteRequestDTO;
import com.spring.mvc.chap05.entify.Board;
import com.spring.mvc.chap05.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardRepository;
    public int getCount;


    //목록 조회 중간 처리
    public List<BoardListResponseDTO> getList(Search page){
        return boardRepository.findAll(page)
                .stream()
                .map(BoardListResponseDTO::new)
                .collect(Collectors.toList());
    }



    public void register(BoardWriteRequestDTO dto) {
        //dto를 엔터티로 변환
        Board board = new Board(dto);
        boardRepository.save(board);
    }

    public void delete(int bno) {
        boardRepository.deleteByNo(bno);
    }

    public BoardDetailResponseDTO getDetail(int bno) {
        Board board = boardRepository.findOne(bno);

        // 조회수 상승처리
        board.upViewCount();

        return new BoardDetailResponseDTO(board);
    }

    public int getCount(Search search) {

        return boardRepository.count(search);
    }
}