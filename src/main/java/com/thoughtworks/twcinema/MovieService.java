package com.thoughtworks.twcinema;

import org.springframework.stereotype.Service;

// 业务逻辑层
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // 获取数据库所有电影
    public Iterable<Movie> getMovies() {
        return movieRepository.findAll();
    }

    // 通过id获取电影
    public Movie getMoviesById(String id) {
        return movieRepository.findById(id).orElse(null);
    }
}
