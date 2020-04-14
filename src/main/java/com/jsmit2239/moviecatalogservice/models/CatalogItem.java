package com.jsmit2239.moviecatalogservice.models;

public class CatalogItem {

    private String userId;
    private String movieId;
    private String movieName;
    private String movieDescription;
    private int rating;

    public CatalogItem(String userId, String movieId, String movieName, String movieDescription, int rating){
        this.userId = userId;
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}

