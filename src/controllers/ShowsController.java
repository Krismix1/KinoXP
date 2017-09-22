package controllers;

import models.Movie;
import models.Show;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chris on 22-Sep-17.
 */
public class ShowsController implements CRUDController<Integer, Show>{
    @Override
    public Show save(Show entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Show get(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Show> getAll() {
        Connection con = DatabaseController.getConnection();
        try {
            Statement query = con.createStatement();
            ResultSet values = query.executeQuery("SELECT * FROM shows");
            List<Show> shows = new LinkedList<>();
            while (values.next()) {
                Show show = new Show();

                int id = values.getInt(1); // id column
                MovieController movieController = new MovieController();
                Movie movie = movieController.get(values.getInt(2)); // movie
                LocalDateTime dateTime = values.getTimestamp(3).toLocalDateTime(); // date and time of the show
                int theater = values.getInt(4); // theater number
                int availableSeats = values.getInt(5);
                double price = values.getDouble(6);

                show.setId(id);
                show.setMovie(movie);
                show.setDateTime(dateTime);
                show.setTheater(theater);
                show.setAvailableSeats(availableSeats);
                show.setPrice(price);

                shows.add(show);
            }

            return shows;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }
}
