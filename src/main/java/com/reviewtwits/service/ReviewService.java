package com.reviewtwits.service;

import com.reviewtwits.entity.Project;
import com.reviewtwits.entity.Review;
import com.reviewtwits.repository.ReviewRepo;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

@Service
public class ReviewService {
    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    public Review submitReviewToDatabase(Review review) throws IOException, ParseException {
        review.setUser(userService.loadUserByUsername(review.getUid()));
        if(!review.getProjectId().equals("")) {
            Project project = projectService.displayProejctMetaData(review.getProjectId());
            if(project.getCategory().equals("movie")) {
                URL url = new URL("http://localhost:5000/movie?q=" + review.getContent());
                BufferedReader buffer;
                buffer = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                String json = buffer.readLine();
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject)jsonParser.parse(json);
                double emotion = (double)jsonObject.get("predict");

                review.setEmotion(emotion);
            } else if(project.getCategory().equals("shopping")) {
                URL url = new URL("http://localhost:5000/shopping?q=" + review.getContent());
                BufferedReader buffer;
                buffer = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                String json = buffer.readLine();
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject)jsonParser.parse(json);
                double emotion = (double)jsonObject.get("predict");

                review.setEmotion(emotion);
            }

        }
        return reviewRepo.save(review);
    }

    public Review updateReviewToDatabase(int reviewId, String uid, String imagePath, String content, int score) {
        Review review = reviewRepo.findReviewByReviewId(reviewId);

        if(review == null || !review.getUid().equals(uid))
            return null;

        review.setImagePath(imagePath);
        review.setContent(content);
        review.setScore(score);
        return reviewRepo.save(review);
    }

    public int deleteReviewToDatabase(int reviewId, String uid) {
        Review review = reviewRepo.findReviewByReviewId(reviewId);
        if(review == null || !review.getUser().getUid().equals(uid))
            return -1;
        reviewRepo.deleteByReviewId(reviewId);
        return 0;
    }

    public ArrayList<Review> retriveReviewFromDB() {
        return reviewRepo.findAll(Sort.by(Sort.Direction.DESC, "reviewId"));
    }

    public ArrayList<Review> displayReviewsByUser(String uid) {
        return reviewRepo.findReviewByUser_Uid(Sort.by(Sort.Direction.DESC, "reviewId"), uid);
    }

    public Review likeCountUpdate(int reviewId) {
        Review review = reviewRepo.findReviewByReviewId(reviewId);
        if(review == null)
            return null;
        review.setLikeCount(review.getLikeCount() + 1);
        return reviewRepo.save(review);
    }
}
