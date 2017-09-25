package logic;

import models.Category;
import models.Movie;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chris on 18-Sep-17.
 */
public class MovieRepository implements CRUDRepository<Integer, Movie> {

    public static final MovieRepository instance = new MovieRepository();
    private MovieRepository(){}

    public List<Movie> getByCategory(Category category) {
        List<Movie> allMovies = getAll();
        return allMovies
                .stream()
                .filter(movie -> movie.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public Movie save(Movie entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Movie get(Integer id) {
        Connection con = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM movies WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Movie movie = new Movie();

                String title = resultSet.getString(2); // title column
                int categoryId = resultSet.getInt(3); // category_id column
                int minimumAge = resultSet.getInt(4); // minimum_age column
                int duration = resultSet.getInt(5); // duration column
                String actors = resultSet.getString(6); //actors column

                movie.setId(id);
                movie.setTitle(title);
                CategoryRepository categoryRepository = CategoryRepository.instance;
                movie.setCategory(categoryRepository.get(categoryId));
                movie.setMinimum_age(minimumAge);
                movie.setDuration(duration);
                movie.setActors(actors);

                return movie;
            }

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public List<Movie> getAll() {
        Connection con = DatabaseConnection.getConnection();
        try {
            Statement query = con.createStatement();
            ResultSet values = query.executeQuery("SELECT * FROM movies");
            List<Movie> movies = new LinkedList<>();
            while (values.next()) {
                Movie movie = new Movie();

                int id = values.getInt(1); // id column
                String title = values.getString(2); // title column
                int categoryId = values.getInt(3); // category_id column
                int minimumAge = values.getInt(4); // minimum_age column
                int duration = values.getInt(5); // duration column
                String actors = values.getString(6); //actors column

                movie.setId(id);
                movie.setTitle(title);
                CategoryRepository categoryRepository = CategoryRepository.instance;
                movie.setCategory(categoryRepository.get(categoryId));
                movie.setMinimum_age(minimumAge);
                movie.setDuration(duration);
                movie.setActors(actors);

                movies.add(movie);
            }

            return movies;
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
