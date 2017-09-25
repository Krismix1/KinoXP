package logic;

import models.Booking;

import java.sql.*;
import java.util.List;

/**
 * Created by Tibi on 25/09/2017.
 */
public class BookingLogic implements CRUDRepository<Integer, Booking> {

    public void bookShowExistingCustomer(Integer userId, Integer showId) {
        Booking booking = new Booking(userId, showId);
        save(booking);
    }

    @Override
    public Booking get(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Booking save(Booking entity) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO bookings VALUES (NULL, ?, ?)");

            stmt.setInt(1, entity.getUserId());
            stmt.setInt(2, entity.getShowId());

            stmt.execute();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Booking> getAll() {
        throw new UnsupportedOperationException();
    }
    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }
}
