package extra.assign;

import java.io.Serializable;

public class Course implements Serializable{
    private int id;
    private String name;
    private String major;
    private String description;

    public Course(){}

    public Course(int id, String name, String major, String description) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.description = description;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
