package com.thoughtworks.twcinema;

import com.thoughtworks.twcinema.MovieClass.MovieDetail;
import com.thoughtworks.twcinema.MovieDetailInfo.MovieDetailInfo;
import org.apache.tomcat.util.buf.StringUtils;
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

    //添加电影到数据库
    public void addMovie(MovieDetail movieDetail) {
        movieRepository.addMovie(movieDetail.getRating().getMax(),
                movieDetail.getTitle(),
                movieDetail.getOriginal_title(),
                movieDetail.getYear(),
                movieDetail.getDirectors().get(0).getName(),
                Integer.parseInt(movieDetail.getId()),
                StringUtils.join(movieDetail.getGenres(), ','),
                movieDetail.getImages().getSmall(),
                movieDetail.getImages().getMedium(),
                movieDetail.getImages().getLarge()
        );
    }

    //添加演员到数据库
    public void addActor(MovieDetail movieDetail) {
        int id = Integer.parseInt(movieDetail.getId());
        movieDetail.getCasts()
                .forEach(casts -> movieRepository.addActor(casts.getName(),
                        casts.getAvatars().getSmall(),
                        casts.getAvatars().getMedium(),
                        casts.getAvatars().getLarge(),
                        id));
    }

    public void addMovieSummary(MovieDetailInfo movieDetailInfo) {
        movieRepository.addSummary(movieDetailInfo.getSummary(), Integer.parseInt(movieDetailInfo.getId()));
    }

    public void addPopularComment(MovieDetailInfo movieDetailInfo) {
        movieDetailInfo.getPopularComments()
                .forEach(c -> movieRepository
                        .addPopularComment(c.getAuthor().getName(), c.getContent(), Integer.parseInt(movieDetailInfo.getId())));
    }

    // 通过id获取电影
    public Movie getMoviesById(String id) {
        return movieRepository.findById(id).orElse(null);
    }

}
