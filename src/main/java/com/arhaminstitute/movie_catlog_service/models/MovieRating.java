package com.arhaminstitute.movie_catlog_service.models;

public class MovieRating {
    private String movieId;
    private int rating;

    public MovieRating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public MovieRating() {
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
