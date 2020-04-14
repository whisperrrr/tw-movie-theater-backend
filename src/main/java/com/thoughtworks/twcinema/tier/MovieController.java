package com.thoughtworks.twcinema.tier;

import com.thoughtworks.twcinema.MovieClass.MovieList;
import com.thoughtworks.twcinema.MovieDetailInfo.MovieDetailInfo;
import com.thoughtworks.twcinema.entity.Actor;
import com.thoughtworks.twcinema.entity.Comment;
import com.thoughtworks.twcinema.entity.Movie;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 表现层
@CrossOrigin
@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public Iterable<Movie> getMoviesInfo() {
        return movieService.getMovies();
    }

    @PostMapping("/post")
    public MovieList post(@RequestBody MovieList movieList) {
        System.out.println(movieList);
        movieList.getMovies().forEach(movieService::addMovie);
        movieList.getMovies().forEach(movieService::addActor);
        return movieList;
    }

    @PostMapping("/post/{id}")
    public MovieDetailInfo postMovieDetail(@RequestBody MovieDetailInfo movieDetailInfo){
        movieService.addMovieSummary(movieDetailInfo);
        movieService.addPopularComment(movieDetailInfo);
        return movieDetailInfo;
    }

    @GetMapping("/movie/{movieid}")
    public Movie getMovieById(@PathVariable String movieid) {
        return movieService.getMoviesById(movieid);
    }

    @GetMapping("/movie/comment/{movieid}")
    public List<Comment> getMovieCommitById(@PathVariable String movieid) {
        return movieService.getCommitById(movieid);
    }

    @GetMapping("/movie/actor/{movieid}")
    public List<Actor> getMovieActorById(@PathVariable String movieid) {
        return movieService.getActorById(movieid);
    }
}
