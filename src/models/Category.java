package models;

/**
 * Created by Chris on 18-Sep-17.
 */
public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Category) {
            Category catObj = (Category) obj;
            return this.name.equals(catObj.getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
