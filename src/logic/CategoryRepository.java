package logic;

import models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }
}
