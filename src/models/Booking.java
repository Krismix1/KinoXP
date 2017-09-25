package models;

/**
 * Created by Tibi on 25/09/2017.
 */
public class Booking {
    private int userId;
    private int showId;

    public Booking(int userId, int showId) {
        this.userId = userId;
        this.showId = showId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }
}
