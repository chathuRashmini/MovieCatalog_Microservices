package com.microservices.RatingsDataService.resources;

import com.microservices.RatingsDataService.models.Rating;
import com.microservices.RatingsDataService.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingData")
public class RatingResources {

    UserRating userRating = new UserRating();

    @PostConstruct
    public void createMovieRatings() {
        List<Rating> movieRatings = Arrays.asList(
                new Rating("Twilight", 4),
                new Rating("New Moon", 3),
                new Rating("Eclipse", 4),
                new Rating("Breaking Dawn", 5)
        );
        userRating.setUserRating(movieRatings);
        System.out.println("user ratings: " + userRating);
    }

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {

        Rating foundRating = new Rating();

        userRating.getUserRating().forEach(rating -> {
            System.out.println("rating: " + rating);

            if (rating.getMovieId() == movieId) {
                foundRating.setRating(rating.getRating());
                foundRating.setMovieId(movieId);
            }
        });
        return foundRating;
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        return userRating;
    }
}
