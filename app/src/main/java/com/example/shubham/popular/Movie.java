package com.example.shubham.popular;

/**
 * Created by shubham on 3/25/2018.
 */

public class Movie {
    int id;
    float vote_average;
    String title;
    String poster_path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Movie(int id, float vote_average, String title, String poster_path) {

        this.id = id;
        this.vote_average = vote_average;
        this.title = title;
        this.poster_path = poster_path;
    }
}
