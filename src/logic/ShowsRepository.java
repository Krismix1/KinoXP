package logic;

import models.Category;
import models.Movie;
import models.Show;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chris on 22-Sep-17.
 */
public class ShowsRepository implements CRUDRepository<Integer, Show> {

    public static final ShowsRepository instance = new ShowsRepository();
    private ShowsRepository(){}

    @Override
    public Show save(Show entity) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO shows VALUES (NULL, ?, ?, ?, ?, ?)");

            stmt.setInt(1, entity.getMovie().getId());
            stmt.setTimestamp(2, Timestamp.valueOf(entity.getDateTime()));
            stmt.setInt(3, entity.getTheater());
            stmt.setInt(4, entity.getAvailableSeats());
            stmt.setDouble(5, entity.getPrice());

            stmt.execute();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Show get(Integer id) {
        throw new UnsupportedOperationException();
    }

    public List<Show> getByCategory(Category category){
        return getAll()
                .stream()
                .filter(show -> show.getMovie().getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<Show> getAll() {
        Connection con = DatabaseConnection.getConnection();
        try {
            Statement query = con.createStatement();
            ResultSet values = query.executeQuery("SELECT * FROM shows");
            List<Show> shows = new LinkedList<>();
            while (values.next()) {
                Show show = new Show();

                int id = values.getInt(1); // id column
                MovieRepository movieController = MovieRepository.instance;
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
