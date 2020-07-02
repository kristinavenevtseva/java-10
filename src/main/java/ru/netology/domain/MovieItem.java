package ru.netology.domain;

public class MovieItem {
    private int id;
    private String movieName;
    private String movieGenre;
    private String imageUrl;
    private boolean premiereTomorrow;

    public MovieItem(int id, String movieName, String movieGenre, String imageUrl, boolean premiereTomorrow) {
        this.id = id;
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.imageUrl = imageUrl;
        this.premiereTomorrow = premiereTomorrow;
    }

    public int getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isPremiereTomorrow() {
        return premiereTomorrow;
    }
}
