package com.fairytale.server.controller.book;

import com.fairytale.server.model.book.dto.*;
import com.fairytale.server.service.book.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/server/book")
public class BookController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @Autowired
    private ChatGptService chatGptService;

    @PostMapping("/api/chatgpt")
    public ChatGptResponseDto chatWithGpt(@RequestBody ChatGptRequestDto requestDto) {
        System.out.print(requestDto.getPrompt());
        System.out.print(requestDto.getPrompt());
        requestDto.setPrompt(requestDto.getPrompt());
        requestDto.setModel("gpt-3.5-turbo");

        return chatGptService.getChatGptResponse(requestDto);
    }

    // 책 보기
    @PostMapping("/viewBook")
    @ResponseBody
    public HashMap<String, Object> viewBook(@RequestBody BookDto bookDto) {
        HashMap<String, Object> mv = new HashMap<>();

        Integer userPageNum = bookService.selectBook(bookDto);

        bookDto = bookService.viewBook(bookDto);

        if(userPageNum != null) {
            bookDto.setUserPageNum(userPageNum);
        }

        mv.put("viewBook", bookDto);

        return mv;
    }

    @PostMapping("/pageData")
    @ResponseBody
    public HashMap<String, Object> pageData(@RequestBody BookDto bookDto) {

        HashMap<String, Object> mv = new HashMap<>();

        bookDto = bookService.pageData(bookDto);

        mv.put("pageData", bookDto);

        return mv;
    }

    @PostMapping("/create")
    @ResponseBody
    public HashMap<String, Object> createBook(@RequestParam("userId") String userId ,@RequestParam("userName") String userName) {

        HashMap<String, Object> mv = new HashMap<>();
        BookDto bookDto = new BookDto();
        bookDto.setId(userId);
        bookDto.setName(userName);
        System.out.println(bookDto.getId());

        System.out.println(bookDto.getName());
        bookService.createBook(bookDto);

        int seqNum = bookService.getLastSeqNum();

        bookDto.setSeqNum(seqNum);
        mv.put("lastSeqNum", bookDto);

        return mv;
    }

    @PostMapping("/context")
    public void getLastSeqNum(@RequestParam("seqNum") int seqNum, @RequestParam("context") String context, @RequestParam("image") String image, @RequestParam("pagenum") int pagenum){
        BookDto bookDto = new BookDto();

        bookDto.setSeqNum(seqNum);
        bookDto.setText(context);
        bookDto.setImage(image);
        bookDto.setPageNum(pagenum);
        bookService.insertContext(bookDto);
        bookService.insertImage(bookDto);
    }

    @PostMapping("/complete") //책완성
    @ResponseBody
    public HashMap<String, Object> getMaxPageNumFromContextAndImage(@RequestBody BookDto bookDto) {

        HashMap<String, Object> mv = new HashMap<>();
        int pageNum = bookService.getMaxPageNumFromContextAndImage(bookDto);
        bookDto.setPageNum(pageNum);
        mv.put("saveBook", bookDto);

        bookService.updateBookPageNum(bookDto);
        return mv;
    }

    @PostMapping("deleteBook")
    @ResponseBody
    public void cancelBook(@RequestBody BookDto bookDto) {
        bookService.deleteContextBySeqNum(bookDto);
        bookService.deleteImageBySeqNum(bookDto);
        bookService.deleteRecentlyBySeqNum(bookDto);
        bookService.deleteBookBySeqNum(bookDto);
    }

    @PostMapping("/getContext")
    @ResponseBody
    public HashMap<String, Object> getContext(@RequestBody BookDto bookDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<BookDto> list = bookService.getContext(bookDto);

        mv.put("getContext", list);

        return mv;
    }

    @PostMapping("/myFairyTale")
    @ResponseBody
    public HashMap<String, Object> myFairyTale(@RequestBody BookDto bookDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<BookDto> list = bookService.myFairyTale(bookDto);

        mv.put("myFairyTale", list);

        return mv;
    }

    @PostMapping("/selectRecently")
    @ResponseBody
    public HashMap<String, Object> selectRecently(@RequestBody BookDto bookDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<BookDto> list = bookService.selectRecently(bookDto);

        mv.put("selectRecently", list);

        return mv;
    }

    @PostMapping("/updateRecently")
    @ResponseBody
    public void updateRecently(@RequestBody BookDto bookDto) {
        bookService.updateRecently(bookDto);
    }

    @PostMapping("/deleteRecently")
    @ResponseBody
    public void deleteRecently(@RequestBody BookDto bookDto) { bookService.deleteRecentlyBySeqNum(bookDto); }

    @PostMapping("/noTitleDelete")
    @ResponseBody
    public void noTitleDelete(@RequestBody BookDto bookDto) {
        System.out.println("@@@@@@"+bookDto.getId());
        bookService.noTitleDelete(bookDto);
    }
}
