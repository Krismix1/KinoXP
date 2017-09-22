package models;

/**
 * Created by Tibi on 22/09/2017.
 */
public class Customer {
    private int id;
    private String Name;
    private String Email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
