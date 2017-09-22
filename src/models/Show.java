package models;

import java.time.LocalDateTime;

/**
 * Created by Chris on 22-Sep-17.
 */
public class Show {
    private int id;
    private Movie movie;
    private LocalDateTime dateTime;
    private int theater;
    private int availableSeats;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getTheater() {
        return theater;
    }

    public void setTheater(int theater) {
        this.theater = theater;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
