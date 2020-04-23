package test.model;

public class User {
    private int id;
    private String name;
    private int maxPoints;

    public User(int id, String name, int maxPoints) {
        this.id = id;
        this.name = name;
        this.maxPoints = maxPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
}
