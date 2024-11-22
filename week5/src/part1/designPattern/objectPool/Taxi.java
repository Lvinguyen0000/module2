package part1.designPattern.objectPool;

public class Taxi {
    private long id;

    public Taxi() {
    }

    public Taxi(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id=" + id +
                '}';
    }
}
