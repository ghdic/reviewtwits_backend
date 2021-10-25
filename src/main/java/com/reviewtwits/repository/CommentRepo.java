package com.reviewtwits.repository;

import com.reviewtwits.entity.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
    Comment save(Comment comment);
    ArrayList<Comment> findCommentsByUser_Uid(Sort sort, String user_uid);
    ArrayList<Comment> findCommentsByReviewId(Sort sort, int reviewId);
    Comment findCommentsByCommentId(int commentId);

    @Transactional
    void deleteCommentByCommentId(int commentId);

}
