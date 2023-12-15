package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.common.Page;
import com.spring.mvc.chap05.entify.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 목록 조회
    List<Board> findAll(Page page);

    // 상세 조회
    Board findOne(int boardNo);

    // 게시물 등록
    boolean save(Board board);


    // 게시물 삭제
    boolean deleteByNo(int boardNo);

   boolean updateCount(int boardNo);

    int count();
}
