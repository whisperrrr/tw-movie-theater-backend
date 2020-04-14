package com.thoughtworks.twcinema.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

public class Movie {
    @Id
    private int id;
    @Column("title")
    private String name;
    @Column("year")
    @JsonFormat(pattern = "yyyy",timezone = "GMT+8")
    private Date year;
    @Column("rating")
    private float rating;
    @Column("original_title")
    private String originTitle;
    @Column("directors")
    private String director;
    @Column("genres")
    private String type;
    @Column("small")
    private String smallImg;
    @Column("median")
    private String medianImg;
    @Column("large")
    private String largeImg;
    @Column("summary")
    private String summary;
//    @Column("language")
//    private String language;
//    @Column("time")
//    private String time;
//    @Column("rate")
//    private String rate;
//    @Column("actor")
//    private String actor;
//    @Column("content")
//    private String content;
//    @Column("comment")
//    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getYear() {
        // 输出年方案一
//        Calendar instance = Calendar.getInstance();
//        instance.setTime(year);
//        return instance.get(Calendar.YEAR);
        // 输出年方案二
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public String getMedianImg() {
        return medianImg;
    }

    public void setMedianImg(String medianImg) {
        this.medianImg = medianImg;
    }

    public String getLargeImg() {
        return largeImg;
    }

    public void setLargeImg(String largeImg) {
        this.largeImg = largeImg;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
