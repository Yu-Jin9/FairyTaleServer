package com.fairytale.server.controller.comment;

import com.fairytale.server.model.comment.dto.CommentDto;
import com.fairytale.server.service.comment.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/server/comment")
public class CommentController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public HashMap<String, Object> addComment(@RequestBody CommentDto commentDto) {

        HashMap<String, Object> mv = new HashMap<>();

        commentService.addComment(commentDto);
        commentService.updateCommentCount(commentDto);

        List<CommentDto> list =  commentService.selectComment(commentDto);

        mv.put("selectComment", list);

        return mv;
    }

    @PostMapping("/deleteComment")
    public HashMap<String, Object> deleteComment(@RequestBody CommentDto commentDto) {
        HashMap<String, Object> mv = new HashMap<>();

        commentService.deleteComment(commentDto);
        commentService.decrementCommentCount(commentDto);

        List<CommentDto> list =  commentService.selectComment(commentDto);

        mv.put("selectComment", list);

        return mv;
    }

    @PostMapping("/selectComment")
    public HashMap<String, Object> selectComment(@RequestBody CommentDto commentDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<CommentDto> list =  commentService.selectComment(commentDto);

        mv.put("selectComment", list);

        return mv;
    }
}
