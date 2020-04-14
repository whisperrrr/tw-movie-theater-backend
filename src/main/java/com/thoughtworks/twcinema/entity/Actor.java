package com.thoughtworks.twcinema.entity;

import org.springframework.data.relational.core.mapping.Column;

public class Actor {
    // TODO 根据后台数据写上column
    @Column("id")
    private int movieId;
    @Column("actor_name")
    private String name;
    @Column("small")
    private String smallImg;
    @Column("median")
    private String mediumImg;
    @Column("large")
    private String largeImg;

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

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public String getMediumImg() {
        return mediumImg;
    }

    public void setMediumImg(String mediumImg) {
        this.mediumImg = mediumImg;
    }

    public String getLargeImg() {
        return largeImg;
    }

    public void setLargeImg(String largeImg) {
        this.largeImg = largeImg;
    }
}
