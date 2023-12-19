package com.fairytale.server.service.comment;

import com.fairytale.server.model.comment.dto.CommentDto;
import com.fairytale.server.model.comment.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentMapper commentMapper;

    @Override
    public void addComment(CommentDto commentDto) {
        commentMapper.addComment(commentDto);
    }

    @Override
    public void updateCommentCount(CommentDto commentDto) {
        commentMapper.updateCommentCount(commentDto);
    }

    @Override
    public void deleteComment(CommentDto commentDto) {
        commentMapper.deleteComment(commentDto);
    }

    @Override
    public void decrementCommentCount(CommentDto commentDto) {
        commentMapper.decrementCommentCount(commentDto);
    }

    @Override
    public List<CommentDto> selectComment(CommentDto commentDto) {
        return commentMapper.selectComment(commentDto);
    }
}
