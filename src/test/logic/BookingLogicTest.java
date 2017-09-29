package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingLogicTest {
    @Test
    void getAll() {
        assertThrows(UnsupportedOperationException.class, () -> {
            BookingLogic bookingLogic = new BookingLogic();
            bookingLogic.getAll();
        });
    }

}