package controllers;

import models.Category;
import models.Movie;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chris on 18-Sep-17.
 */
public class MovieController implements CRUDController<Integer, Movie> {

    public List<Movie> getByCategory(Category category) {
        List<Movie> allMovies = getAll();
        return allMovies
                .stream()
                .filter(movie -> movie.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Movie entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Movie get(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Movie> getAll() {
        Connection con = DatabaseController.getConnection();
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

                movie.setId(id);
                movie.setTitle(title);
                CategoryController categoryController = new CategoryController();
                movie.setCategory(categoryController.get(categoryId));
                movie.setMinimum_age(minimumAge);
                movie.setDuration(duration);

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
