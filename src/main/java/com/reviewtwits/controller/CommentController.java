package com.reviewtwits.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.reviewtwits.entity.Comment;
import com.reviewtwits.message.request.ContentReq;
import com.reviewtwits.service.CommentService;
import com.reviewtwits.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    FirebaseAuth firebaseAuth;

    @PostMapping("")
    private Comment submitComment(@RequestBody Comment comment) {
        return commentService.submitCommentToDatabase(comment);
    }

    @GetMapping("/{reviewId}")
    private ArrayList<Comment> getCommentsForReview(@PathVariable("reviewId")int reviewId) {
        return commentService.displayCommentsFromReviewId(reviewId);
    }

    @PostMapping("/{commentId}")
    private Comment updateComment(@PathVariable("commentId")int commentId, @RequestHeader("Authorization") String authorization, @RequestBody ContentReq contentReq) {
        return commentService.updateCommentToDatabase(TokenUtil.parseUid(firebaseAuth, authorization), commentId, contentReq.getContent());
    }

    @DeleteMapping("/{commentId}")
    private int deleteComment(@PathVariable("commentId")int commentId, @RequestHeader("Authorization") String authorization) {
        return commentService.deleteCommentFromDatabase(TokenUtil.parseUid(firebaseAuth, authorization), commentId);
    }

    @GetMapping("/user")
    private ArrayList<Comment> getCommentsForUid(@RequestHeader("Authorization") String authorization) {
        return commentService.displayCommentsFromUid(TokenUtil.parseUid(firebaseAuth, authorization));
    }
}
