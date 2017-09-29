package logic;

import models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chris on 29-Sep-17.
 */
public class CustomerRepository implements CRUDRepository<Integer, Customer> {
    private static CustomerRepository instance;
    private CustomerRepository(){}

    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }

    @Override
    public Customer save(Customer entity) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO accounts VALUES (NULL, ?, 'random', ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, entity.getEmail());
            stmt.setString(2, entity.getName());

            stmt.execute();
            ResultSet resultSet = stmt.getGeneratedKeys();
            if(resultSet.next()) {
                entity.setId(resultSet.getInt(1));
                return entity;
            }
            con.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer get(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Customer> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }
}
