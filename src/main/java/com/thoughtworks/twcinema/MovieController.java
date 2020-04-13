package com.thoughtworks.twcinema;

import com.thoughtworks.twcinema.MovieClass.MovieList;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @PostMapping("/post")
    public MovieList post(@RequestBody MovieList movieList) {
        System.out.println(movieList);
        movieList.getMovies().forEach(m -> movieService.addMovie(m));
        movieList.getMovies().forEach(m -> movieService.addActor(m));
        return movieList;
    }
}
