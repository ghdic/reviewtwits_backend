package com.reviewtwits.repository;

import com.reviewtwits.entity.Review;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
    Review save(Review review);
    Review findReviewByReviewId(int reviewId);
    ArrayList<Review> findAll(Sort sort);
    ArrayList<Review> findReviewByUser_Uid(Sort sort, String user_uid);
    void deleteByReviewId(int reviewId);
}
