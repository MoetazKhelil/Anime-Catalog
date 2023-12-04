package dev.moetaz.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String ranking) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Anime.class)
                .matching(Criteria.where("ranking").is(ranking))
                .apply(new Update().push("reviewIds").value(review)).first();

        return review;
    }
}
