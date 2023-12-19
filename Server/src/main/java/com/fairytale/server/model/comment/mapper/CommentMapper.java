package com.fairytale.server.model.comment.mapper;

import com.fairytale.server.model.comment.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    void addComment (CommentDto commentDto);

    void updateCommentCount (CommentDto commentDto);

    void deleteComment (CommentDto commentDto);

    void decrementCommentCount (CommentDto commentDto);

    List<CommentDto> selectComment (CommentDto commentDto);
}
