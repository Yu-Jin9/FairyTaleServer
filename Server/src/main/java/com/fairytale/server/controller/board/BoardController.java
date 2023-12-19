package com.fairytale.server.controller.board;

import com.fairytale.server.model.board.dto.*;
import com.fairytale.server.service.board.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/server/board")
public class BoardController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BoardService boardService;

    // 최신순 리스트
    @PostMapping("/boardList")
    @ResponseBody
    public HashMap<String, Object> boardList(@RequestBody BoardDto boardDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<BoardDto> list = boardService.boardList(boardDto);

        int totalCount = boardService.getBoardTotalCount();
        int pageSize = boardDto.getPageSize();
        int currentPage = boardDto.getCurrentPage();
        int totalPages = (int) Math.ceil((double) totalCount / (currentPage * pageSize));

        mv.put("boardList", list);
        mv.put("totalPages", totalPages);

        return mv;
    }

    // 좋아요 순 리스트
    @PostMapping("/likeBoardList")
    @ResponseBody
    public HashMap<String, Object> likeBoardList(@RequestBody BoardDto boardDto) {

        HashMap<String, Object> mv = new HashMap<>();

        List<BoardDto> list = boardService.likeBoardList(boardDto);

        int totalCount = boardService.getBoardTotalCount();
        int pageSize = boardDto.getPageSize();
        int currentPage = boardDto.getCurrentPage();
        int totalPages = (int) Math.ceil((double) totalCount / (currentPage * pageSize));

        mv.put("boardList", list);
        mv.put("totalPages", totalPages);

        return mv;
    }

    // 조회수 순 리스트
    @PostMapping("/viewBoardList")
    @ResponseBody
    public HashMap<String, Object> viewBoardList(@RequestBody BoardDto boardDto) {

        HashMap<String, Object> mv = new HashMap<>();

        List<BoardDto> list = boardService.viewBoardList(boardDto);

        int totalCount = boardService.getBoardTotalCount();
        int pageSize = boardDto.getPageSize();
        int currentPage = boardDto.getCurrentPage();
        int totalPages = (int) Math.ceil((double) totalCount / (currentPage * pageSize));

        mv.put("boardList", list);
        mv.put("totalPages", totalPages);

        return mv;
    }

    // 댓글 순 리스트
    @PostMapping("/commentBoardList")
    @ResponseBody
    public HashMap<String, Object> commentBoardList(@RequestBody BoardDto boardDto) {

        HashMap<String, Object> mv = new HashMap<>();

        List<BoardDto> list = boardService.commentBoardList(boardDto);

        int totalCount = boardService.getBoardTotalCount();
        int pageSize = boardDto.getPageSize();
        int currentPage = boardDto.getCurrentPage();
        int totalPages = (int) Math.ceil((double) totalCount / (currentPage * pageSize));

        mv.put("boardList", list);
        mv.put("totalPages", totalPages);

        return mv;
    }

    // 선택한 Board 가져오기
    @PostMapping("/selectBoard")
    @ResponseBody
    public HashMap<String, Object> selectBoard(@RequestBody BoardDto boardDto) {

        HashMap<String, Object> mv = new HashMap<>();

        boardDto = boardService.selectBoard(boardDto);

        mv.put("selectBoard", boardDto);

        return mv;
    }

    // 좋아요
    @PostMapping("/boardLike")
    @ResponseBody
    public HashMap<String, Integer> boardLike(@RequestParam("userId") String userId, @RequestParam("boardNum") int boardNum) {
        BoardDto boardDto = new BoardDto();
        boardDto.setUserId(userId);
        boardDto.setBoardNum(boardNum);

        HashMap<String, Integer> mv = new HashMap<>();

        Integer currentLikeStatus = boardService.checkUserLike(boardDto);

        if (currentLikeStatus == null) {
            // 좋아요 상태가 없는 경우, 새로운 레코드를 추가
            boardService.insertUserLike(boardDto);
        } else {
            // 이미 좋아요 상태가 있는 경우, 상태를 업데이트
            boardService.updateUserLike(boardDto);
        }

        boardService.updateBoardLikes(boardDto);

        Integer likeCnt = boardService.getLikeCount(boardDto);

        mv.put("like", likeCnt);

        return mv;
    }

    // 좋아요 아이콘에 사용될 사용자의 좋아요 상태 확인
    @PostMapping("/checkUserLikeState")
    @ResponseBody
    public HashMap<String, Integer> checkUserLikeState (@RequestParam("userId") String userId, @RequestParam("boardNum") int boardNum) {
        BoardDto boardDto = new BoardDto();
        boardDto.setUserId(userId);
        boardDto.setBoardNum(boardNum);

        HashMap<String, Integer> mv = new HashMap<>();

        Integer currentLikeState = boardService.checkUserLikeState(boardDto);

        mv.put("like", currentLikeState);

        return mv;
    }

    // 조회수
    @PostMapping("/boardView")
    @ResponseBody
    public void boardView(@RequestParam("boardNum") int boardNum) {
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardNum(boardNum);

        boardService.boardView(boardDto);
    }

    //게시판 책 올리기
    @PostMapping("/postBook")
    @ResponseBody
    public void insertBoard(@RequestBody BoardDto boardDto) {
        boardService.insertBoard(boardDto);
    }

    @PostMapping("/deleteBoard")
    @ResponseBody
    public void deleteBoard(@RequestBody BoardDto boardDto) {
        boardService.deleteComment(boardDto);
        boardService.deleteLikes(boardDto);
        boardService.deleteBoard(boardDto);
    }

    @PostMapping("/bestBoard")
    @ResponseBody
    public HashMap<String, Object> bestBoard() {
        HashMap<String, Object> mv = new HashMap<>();

        List<BoardDto> list = boardService.bestBoard();

        mv.put("bestBoard", list);

        return mv;
    }

    @PostMapping("/myBoard")
    @ResponseBody
    public HashMap<String, Object> myBoard(@RequestBody BoardDto boardDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<BoardDto> list = boardService.myBoard(boardDto);

        mv.put("myBoard", list);

        return mv;
    }

    @PostMapping("/selectTitle")
    @ResponseBody
    public HashMap<String, Object> selectTitle(@RequestBody BoardDto boardDto) {

        HashMap<String, Object> mv = new HashMap<>();

        List<BoardDto> list = boardService.selectTitle(boardDto);

        mv.put("selectTitle", list);

        return mv;
    }

    //유료회원 홍보 리스트 가져오기
    @PostMapping("/promotionList")
    @ResponseBody
    public HashMap<String, Object> promotionList(@RequestBody BoardDto boardDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<BoardDto> list = boardService.promotionList(boardDto);

        int totalCount = boardService.getBoardTotalCount();
        int pageSize = boardDto.getPageSize();
        int currentPage = boardDto.getCurrentPage();
        int totalPages = (int) Math.ceil((double) totalCount / (currentPage * pageSize));

        mv.put("promotionList", list);
        mv.put("totalPages", totalPages);

        return mv;
    }

    @PostMapping("/myBookList")
    @ResponseBody
    public HashMap<String, Object> myBookList(@RequestBody BoardDto boardDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<BoardDto> list = boardService.myBookList(boardDto);

        int totalCount = boardService.getBookTotalCount();
        int pageSize = boardDto.getPageSize();
        int currentPage = boardDto.getCurrentPage();
        int totalPages = (int) Math.ceil((double) totalCount / (currentPage * pageSize));

        mv.put("myFairyTale",list);
        mv.put("totalPages", totalPages);

        return mv;
    }

    @PostMapping("/myBoardList")
    @ResponseBody
    public HashMap<String, Object> myBoardList(@RequestBody BoardDto boardDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<BoardDto> list = boardService.myBoardList(boardDto);

        int totalCount = boardService.getBoardTotalCount();
        int pageSize = boardDto.getPageSize();
        int currentPage = boardDto.getCurrentPage();
        int totalPages = (int) Math.ceil((double) totalCount / (currentPage * pageSize));

        mv.put("myBoardList",list);
        mv.put("totalPages", totalPages);

        return mv;
    }

    @PostMapping("/makeInfo")
    @ResponseBody
    public HashMap<String, Object> makeInfo(@RequestBody BoardDto boardDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<BoardDto> list = boardService.makeInfo(boardDto);

        mv.put("makeInfo", list);

        return mv;
    }
}
