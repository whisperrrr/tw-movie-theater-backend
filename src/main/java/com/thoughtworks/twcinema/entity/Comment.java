package com.thoughtworks.twcinema.entity;

import org.springframework.data.relational.core.mapping.Column;

public class Comment {
    // TODO 增加相应的行名称
    @Column("id")
    private int movieId;
    @Column("name")
    private String name;
    @Column("comment")
    private String commentInfo;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommitInfo() {
        return commentInfo;
    }

    public void setCommitInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }
}
