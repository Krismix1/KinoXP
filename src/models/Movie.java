package models;

/**
 * Created by Chris on 18-Sep-17.
 */
public class Movie {
    private int id;
    private String title;
    private Category category;
    private int minimum_age;
    private int duration;
    private String actors;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMinimum_age() {
        return minimum_age;
    }

    public void setMinimum_age(int minimum_age) {
        this.minimum_age = minimum_age;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getActors() { return actors; }

    public void setActors(String actors){ this.actors = actors; }

    @Override
    public String toString() {
        return title;
    }
}
