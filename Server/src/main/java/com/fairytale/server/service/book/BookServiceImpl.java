package com.fairytale.server.service.book;

import com.fairytale.server.model.book.dto.BookDto;
import com.fairytale.server.model.book.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void createBook(BookDto bookDto) {
        bookMapper.createBook(bookDto);
    }

    @Override
    public int getLastSeqNum() {
        return bookMapper.getLastSeqNum();
    }

    @Override
    public void insertContext(BookDto bookDto) {
        bookMapper.insertContext(bookDto);
    }

    @Override
    public void insertImage(BookDto bookDto) {
        bookMapper.insertImage(bookDto);
    }

    @Override
    public int getMaxPageNumFromContextAndImage(BookDto bookDto){
       return bookMapper.getMaxPageNumFromContextAndImage(bookDto);
    }

    @Override
    public void updateBookPageNum(BookDto bookDto) {
        bookMapper.updateBookPageNum(bookDto);
    }

    @Override
    public BookDto viewBook(BookDto bookDto) { return bookMapper.viewBook(bookDto); }

    @Override
    public BookDto pageData(BookDto bookDto) { return bookMapper.pageData(bookDto); }

    @Override
    public void deleteContextBySeqNum(BookDto bookDto) { bookMapper.deleteContextBySeqNum(bookDto); }

    @Override
    public void deleteImageBySeqNum(BookDto bookDto) { bookMapper.deleteImageBySeqNum(bookDto); }

    @Override
    public void deleteRecentlyBySeqNum(BookDto bookDto) { bookMapper.deleteRecentlyBySeqNum(bookDto); }

    @Override
    public void deleteBookBySeqNum(BookDto bookDto) { bookMapper.deleteBookBySeqNum(bookDto); }

    @Override
    public List<BookDto> getContext(BookDto bookDto) { return bookMapper.getContext(bookDto); }

    @Override
    public List<BookDto> myFairyTale(BookDto bookDto) { return bookMapper.myFairyTale(bookDto); }

    @Override
    public Integer selectBook(BookDto bookDto) { return bookMapper.selectBook(bookDto); }

    @Override
    public List<BookDto> selectRecently(BookDto bookDto) { return bookMapper.selectRecently(bookDto); }

    @Override
    public void updateRecently(BookDto bookDto) { bookMapper.updateRecently(bookDto); }

    @Override
    public void noTitleDelete(BookDto bookDto) { bookMapper.noTitleDelete(bookDto); }
}
