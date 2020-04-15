package com.thoughtworks.twcinema.tier;

import com.thoughtworks.twcinema.entity.Actor;
import com.thoughtworks.twcinema.entity.Comment;
import com.thoughtworks.twcinema.entity.Movie;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// 数据访问层
public interface MovieRepository extends CrudRepository<Movie, String> {
    @Modifying
    @Query("INSERT INTO movie (`rating`, `title`, `original_title`, `id`, `year`, `directors`, `genres`, `small`, `median`, `large`, `durations`) " +
            "VALUES (:rating, :title, :original_title, :id , :year, :directors, :genres, :small, :median, :large, :durations);")
    void addMovie(@Param("rating") double rating,
                  @Param("title") String title,
                  @Param("original_title") String original_title,
                  @Param("year") String year,
                  @Param("directors") String directors,
                  @Param("id") int id,
                  @Param("genres") String genres,
                  @Param("small") String small,
                  @Param("median") String median,
                  @Param("large") String large,
                  @Param("durations") String durations
                  );

    @Modifying
    @Query("INSERT INTO actor (`id`, `actor_name`, `small`, `median`, `large`) " +
            "VALUES (:id, :name, :small, :median, :large);")
    void addActor(@Param("name") String name,
                  @Param("small") String small,
                  @Param("median") String median,
                  @Param("large") String large,
                  @Param("id") int id);
    @Modifying
    @Query("INSERT INTO popular_comments (`id`, `name`, `comment`) VALUES (:id, :name, :comment);")
    void addPopularComment(@Param("name") String name,
                           @Param("comment") String comment,
                           @Param("id") int id);

    @Modifying
    @Query("UPDATE movie SET `summary` = :summary WHERE (`id` = :id);")
    void addSummary(@Param("summary") String summary,
                    @Param("id") int id);

    @Modifying
    @Query("UPDATE movie SET `language` = :language WHERE (`id` = :id);")
    void addLanguage(@Param("language") String language,
                    @Param("id") int id);

    @Query("SELECT id,name,comment FROM popular_comments WHERE id = :id")
    List<Comment> getCommit(@Param("id") String id);

    @Query("SELECT id,actor_name,small,median,large FROM actor WHERE id = :id")
    List<Actor> getActor(@Param("id") String id);
}
