package logic;

import models.Category;
import models.Movie;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chris on 18-Sep-17.
 */
public class CategoryRepository implements CRUDRepository<Integer, Category> {
    public static final CategoryRepository instance = new CategoryRepository();
    private CategoryRepository(){}


    @Override
    public Category save(Category entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Category get(Integer id) {
        Connection con = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT `name` FROM categories WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Category category = new Category(resultSet.getString(1));
                category.setId(id);
                return category;
            }

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public List<Category> getAll() {
        Connection con = DatabaseConnection.getConnection();
        try {
            Statement query = con.createStatement();
            ResultSet values = query.executeQuery("SELECT * FROM categories");
            List<Category> categories = new LinkedList<>();
            while (values.next()) {
                Category category = new Category("");

                int id = values.getInt(1); // id column
                String name = values.getString(2); // title column

                category.setId(id);
                category.setName(name);
                CategoryRepository categoryRepository = CategoryRepository.instance;

                categories.add(category);
            }

            return categories;
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
