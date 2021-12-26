package com.microservices.MovieInfoService.resources;

import com.microservices.MovieInfoService.models.Movie;
import com.microservices.MovieInfoService.models.MovieList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    MovieList movieList = new MovieList();

    @PostConstruct
    public void createMovieDetails() {
        List<Movie> movies = Arrays.asList(
            new Movie("Twilight", "First movie of the Twilight saga"),
            new Movie("New Moon", "Second movie of the Twilight saga"),
            new Movie("Eclipse", "Third movie of the Twilight saga"),
            new Movie("Breaking Dawn", "Fourth movie of the Twilight saga")
        );
        movieList.setMovieList(movies);
        System.out.println("Movies in info svc: " + movieList);
    }

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        System.out.println("Inside the api in movie info svc: " + movieList.getMovieList());

        Movie foundMovie = new Movie();

        movieList.getMovieList().forEach(movie -> {
            System.out.println("movie: " + movie);

            if (movieId.equals(movie.getMovie_name())) {
                foundMovie.setMovie_description(movie.getMovie_description());
                foundMovie.setMovie_name(movieId);
            }
        });

        return foundMovie;
    }
}
