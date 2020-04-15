package com.thoughtworks.twcinema.tier;

import com.thoughtworks.twcinema.MovieClass.MovieDetail;
import com.thoughtworks.twcinema.MovieDetailInfo.MovieDetailInfo;
import com.thoughtworks.twcinema.entity.Actor;
import com.thoughtworks.twcinema.entity.Comment;
import com.thoughtworks.twcinema.entity.Movie;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (movieDetail == null) {
            movieDetail = new MovieDetail();
        }
        movieRepository.addMovie(movieDetail.getRating().getAverage(),
                movieDetail.getTitle(),
                movieDetail.getOriginal_title(),
                movieDetail.getYear(),
                movieDetail.getDirectors().get(0).getName(),
                Integer.parseInt(movieDetail.getId()),
                StringUtils.join(movieDetail.getGenres(), ','),
                movieDetail.getImages().getSmall(),
                movieDetail.getImages().getMedium(),
                movieDetail.getImages().getLarge(),
                movieDetail.getDurations().get(0)
        );
    }

    //添加演员到数据库
    public void addActor(MovieDetail movieDetail) {
        if (movieDetail == null) {
            movieDetail = new MovieDetail();
        }
        int id = Integer.parseInt(movieDetail.getId());
        movieDetail.getCasts()
                .forEach(casts -> {
                    movieRepository.addActor(casts.getName(),
                            casts.getAvatars().getSmall(),
                            casts.getAvatars().getMedium(),
                            casts.getAvatars().getLarge(),
                            id);
                });
    }

    public void addMovieSummary(MovieDetailInfo movieDetailInfo) {
        movieRepository.addSummary(movieDetailInfo.getSummary(), Integer.parseInt(movieDetailInfo.getId()));
    }

    public void addLanguage (MovieDetailInfo movieDetailInfo) {
        movieRepository.addLanguage(movieDetailInfo.getLanguages().get(0), Integer.parseInt(movieDetailInfo.getId()));
    }

    public void addPopularComment(MovieDetailInfo movieDetailInfo) {
        movieDetailInfo.getPopularComments()
                .forEach(c -> movieRepository
                        .addPopularComment(c.getAuthor().getName(), c.getContent(), Integer.parseInt(movieDetailInfo.getId())));
    }

    // 通过id获取电影
    // 需要的东西  title,origin_title
    // genres(type),lanuguage,pubdate,duration,rating,directorname,castname
    // smallimage,cast[0]smallimg,cast[1]smallimg
    // summary
    // commit(单独发ajax吧)
    public Movie getMoviesById(String id) {
        return movieRepository.findById(id).orElse(null);
    }

    // 通过id获取电影评论列表
    public List<Comment> getCommitById(String id) {
        return movieRepository.getCommit(id);
    }

    // 通过id获取演员列表
    public List<Actor> getActorById(String id) {
        return movieRepository.getActor(id);
    }

}
