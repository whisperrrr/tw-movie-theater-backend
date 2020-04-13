package com.thoughtworks.twcinema.MovieClass;

import java.util.List;
/**
 * Copyright 2020 bejson.com
 */

/**
 * Auto-generated: 2020-04-13 17:12:45
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class MovieList{

    private List<MovieDetail> movies;

    public List<MovieDetail> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDetail> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "movies=" + movies +
                '}';
    }
}
