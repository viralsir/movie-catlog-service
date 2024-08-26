package com.arhaminstitute.movie_catlog_service.models;

public class CatlogItem {

    private String movieId;
    private String movieName;
    private int ratings;

    public CatlogItem() {
    }

    public CatlogItem(String movieId, String movieName, int ratings) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.ratings = ratings;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
