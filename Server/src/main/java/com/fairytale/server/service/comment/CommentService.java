package com.fairytale.server.service.comment;

import com.fairytale.server.model.comment.dto.CommentDto;

import java.util.List;

public interface CommentService {

    void addComment (CommentDto commentDto);

    void updateCommentCount (CommentDto commentDto);

    void deleteComment (CommentDto commentDto);

    void decrementCommentCount (CommentDto commentDto);

    List<CommentDto> selectComment (CommentDto commentDto);
}
