package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.entify.Board;

import java.util.List;

// ㄱㅔ시판 CRUD 기능 명세
public interface BoardRepository {

    // 목록 조회
    List<Board> findAll();

    // 상세 조회
    Board findOne(int boardNo);

    // 게시물 등록
    boolean save(Board board);

    // 게시물 삭제
    boolean deleteByNo(int boardNo);
}
