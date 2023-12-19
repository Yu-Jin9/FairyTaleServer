package com.fairytale.server.service.board;

import com.fairytale.server.model.board.dto.BoardDto;

import java.util.List;

public interface BoardService {

    Integer getBookTotalCount ();

    Integer getBoardTotalCount ();

    List<BoardDto> boardList (BoardDto boardDto);

    List<BoardDto> likeBoardList (BoardDto boardDto);

    List<BoardDto> viewBoardList (BoardDto boardDto);

    List<BoardDto> commentBoardList (BoardDto boardDto);

    BoardDto selectBoard (BoardDto boardDto);

    Integer checkUserLike (BoardDto boardDto);

    Integer checkUserLikeState (BoardDto boardDto);

    void updateUserLike (BoardDto boardDto);

    void insertUserLike (BoardDto boardDto);

    void updateBoardLikes (BoardDto boardDto);

    Integer getLikeCount (BoardDto boardDto);

    void boardView (BoardDto boardDto);

    void insertBoard (BoardDto boardDto);

    void deleteComment (BoardDto boardDto);

    void deleteLikes (BoardDto boardDto);

    void deleteBoard (BoardDto boardDto);

    List<BoardDto> bestBoard ();

    List<BoardDto> myBoard (BoardDto boardDto);

    List<BoardDto> selectTitle (BoardDto boardDto);

    List<BoardDto> promotionList (BoardDto boardDto);

    List<BoardDto> myBookList (BoardDto boardDto);

    List<BoardDto> myBoardList(BoardDto boardDto);

    List<BoardDto> makeInfo(BoardDto boardDto);
}
