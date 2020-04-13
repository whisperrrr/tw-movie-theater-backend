package com.thoughtworks.twcinema;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 表现层
@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @CrossOrigin
    @GetMapping("/movies")
    public Iterable<Movie> getMoviesInfo() {
        return movieService.getMovies();
    }


}
