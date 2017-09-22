package controllers;

import models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chris on 18-Sep-17.
 */
public class CategoryController implements CRUDController<Integer, Category> {

    @Override
    public Category save(Category entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Category get(Integer id) {
        Connection con = DatabaseController.getConnection();
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
