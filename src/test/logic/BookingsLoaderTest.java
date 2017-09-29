package logic;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingsLoaderTest {
    @Test
    void customerOrder() {
        BookingsLoader bookingsLoader = new BookingsLoader();
        ObservableList list = bookingsLoader.customerOrder("123");
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

}