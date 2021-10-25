package com.reviewtwits.service;

import com.reviewtwits.entity.Comment;
import com.reviewtwits.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

@Service
public class CommentService {
    CommentRepo commentRepo;
    UserService userService;

    public CommentService(CommentRepo commentRepo, UserService userService) {
        this.commentRepo = commentRepo;
        this.userService = userService;
    }

    public Comment submitCommentToDatabase(Comment comment) {
        comment.setUser(userService.loadUserByUsername(comment.getUid()));
        comment.setCreateDate(LocalDateTime.now(ZoneId.of("Asia/Seoul")));
        return commentRepo.save(comment);
    }

    public Comment updateCommentToDatabase(String uid, int commentId, String content) {
        Comment comment = commentRepo.findCommentsByCommentId(commentId);
        if(comment == null || !comment.getUser().getUid().equals(uid))
            return null;
        comment.setContent(content);
        return commentRepo.save(comment);
    }

    @Transactional
    public int deleteCommentFromDatabase(String uid, int commentId) {
        Comment comment = commentRepo.findCommentsByCommentId(commentId);
        if(comment == null || !comment.getUser().getUid().equals(uid))
            return -1;
        commentRepo.deleteCommentByCommentId(commentId);
        return 0;
    }

    public ArrayList<Comment> displayCommentsFromUid(String uid) {
        return commentRepo.findCommentsByUser_Uid(Sort.by(Sort.Direction.DESC, "commentId"), uid);
    }

    public ArrayList<Comment> displayCommentsFromReviewId(int reviewId) {
        return commentRepo.findCommentsByReviewId(Sort.by(Sort.Direction.DESC, "commentId"), reviewId);
    }
}
