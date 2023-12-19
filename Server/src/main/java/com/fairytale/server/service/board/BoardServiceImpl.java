package com.fairytale.server.service.board;

import com.fairytale.server.model.board.dto.BoardDto;
import com.fairytale.server.model.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public Integer getBookTotalCount() {
        return boardMapper.getBookTotalCount();
    }

    @Override
    public Integer getBoardTotalCount() {
        return boardMapper.getBoardTotalCount();
    }

    @Override
    public List<BoardDto> boardList(BoardDto boardDto) {
        return boardMapper.boardList(boardDto);
    }

    @Override
    public List<BoardDto> likeBoardList(BoardDto boardDto) {
        return boardMapper.likeBoardList(boardDto);
    }

    @Override
    public List<BoardDto> viewBoardList(BoardDto boardDto) {
        return boardMapper.viewBoardList(boardDto);
    }

    @Override
    public List<BoardDto> commentBoardList(BoardDto boardDto) {
        return boardMapper.commentBoardList(boardDto);
    }

    @Override
    public BoardDto selectBoard(BoardDto boardDto) {
        return boardMapper.selectBoard(boardDto);
    }

    @Override
    public Integer checkUserLike(BoardDto boardDto) {
        return boardMapper.checkUserLike(boardDto);
    }

    @Override
    public Integer checkUserLikeState(BoardDto boardDto) { return boardMapper.checkUserLikeState(boardDto); }

    @Override
    public void updateUserLike(BoardDto boardDto) {
        boardMapper.updateUserLike(boardDto);
    }

    @Override
    public void insertUserLike(BoardDto boardDto) {
        boardMapper.insertUserLike(boardDto);
    }

    @Override
    public void updateBoardLikes(BoardDto boardDto) {
        boardMapper.updateBoardLikes(boardDto);
    }

    @Override
    public Integer getLikeCount(BoardDto boardDto) {
        return boardMapper.getLikeCount(boardDto);
    }

    @Override
    public void boardView(BoardDto boardDto) {
        boardMapper.boardView(boardDto);
    }

    @Override
    public void insertBoard(BoardDto boardDto) { boardMapper.insertBoard(boardDto); }

    @Override
    public void deleteComment(BoardDto boardDto) { boardMapper.deleteComment(boardDto); }

    @Override
    public void deleteLikes(BoardDto boardDto) { boardMapper.deleteLikes(boardDto); }

    @Override
    public void deleteBoard(BoardDto boardDto) { boardMapper.deleteBoard(boardDto); }

    @Override
    public List<BoardDto> bestBoard() { return boardMapper.bestBoard(); }

    @Override
    public List<BoardDto> myBoard(BoardDto boardDto) { return boardMapper.myBoard(boardDto); }

    @Override
    public List<BoardDto> selectTitle(BoardDto boardDto) { return boardMapper.selectTitle(boardDto); }

    @Override
    public List<BoardDto> promotionList(BoardDto boardDto) { return boardMapper.promotionList(boardDto); }

    @Override
    public List<BoardDto> myBookList(BoardDto boardDto) { return boardMapper.myBookList(boardDto); }

    @Override
    public List<BoardDto> myBoardList(BoardDto boardDto) { return boardMapper.myBoardList(boardDto); }

    @Override
    public List<BoardDto> makeInfo(BoardDto boardDto) { return boardMapper.makeInfo(boardDto); }
}
