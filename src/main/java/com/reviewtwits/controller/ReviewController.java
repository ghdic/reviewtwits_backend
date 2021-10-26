package com.reviewtwits.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.reviewtwits.entity.Review;
import com.reviewtwits.message.request.PathReq;
import com.reviewtwits.message.request.ReviewReq;
import com.reviewtwits.service.ReviewService;
import com.reviewtwits.util.RequestUtil;
import com.reviewtwits.util.TokenUtil;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    FirebaseAuth firebaseAuth;
    @Autowired
    ReviewService reviewService;

    @GetMapping("")
    private ArrayList<Review> getAllReview() {
        return reviewService.retriveReviewFromDB();
    }

    @PostMapping("")
    private Review submitReview(@RequestBody Review review) throws IOException, ParseException {
        return reviewService.submitReviewToDatabase(review);
    }

    @PostMapping("/{reviewId}")
    private Review updateReview(@PathVariable("reviewId") int reviewId ,@RequestHeader("Authorization") String authorization, @RequestBody ReviewReq reviewReq) {

        return reviewService.updateReviewToDatabase(reviewId, TokenUtil.parseUid(firebaseAuth, authorization),
                reviewReq.getImagePath(), reviewReq.getContent(), reviewReq.getScore());
    }

    @DeleteMapping("/{reviewId}")
    private int deleteUserPost(@PathVariable("reviewId") int reviewId, @RequestHeader("Authorization") String authorization) {

        return reviewService.deleteReviewToDatabase(reviewId, TokenUtil.parseUid(firebaseAuth, authorization));
    }

    @GetMapping("/user/{uid}")
    private ArrayList<Review> getReviewsByUser(@PathVariable("uid") String uid) {
        return reviewService.displayReviewsByUser(uid);
    }

    @PostMapping("/like/{reviewId}")
    private Review likeCountIncrase(@PathVariable("reviewId") int reviewId) {
        return reviewService.likeCountUpdate(reviewId);
    }

    @PostMapping("/path")
    private ArrayList<Review> getReviewsByPath(@RequestBody PathReq pathReq) {
        return reviewService.displayReviewsByPath(pathReq.getPath());
    }
}
