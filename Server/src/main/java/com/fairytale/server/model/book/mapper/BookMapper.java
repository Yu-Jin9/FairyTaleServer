package com.fairytale.server.model.book.mapper;


import com.fairytale.server.model.book.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;

import java.awt.print.Book;
import java.util.List;

@Mapper
public interface BookMapper {

    void createBook (BookDto bookDto);

    int getLastSeqNum ();
    void insertContext (BookDto bookDto);
    void insertImage (BookDto bookDto);

    int getMaxPageNumFromContextAndImage (BookDto bookDto);

    void updateBookPageNum (BookDto bookDto);

    BookDto viewBook (BookDto bookDto);

    BookDto pageData (BookDto bookDto);

    void deleteContextBySeqNum (BookDto bookDto);

    void deleteImageBySeqNum (BookDto bookDto);

    void deleteRecentlyBySeqNum (BookDto bookDto);

    void deleteBookBySeqNum (BookDto bookDto);

    List<BookDto> getContext (BookDto bookDto);

    List<BookDto> myFairyTale (BookDto bookDto);

    Integer selectBook (BookDto bookDto);

    List<BookDto> selectRecently (BookDto bookDto);

    void updateRecently (BookDto bookDto);

    void noTitleDelete (BookDto bookDto);

}
