package bgu.spl.net.srv;

import java.util.LinkedList;

public class Course {

    private String name;
    private int courseNum;
    private int seatsAvailable;
    private LinkedList<Course> kdams;

    public Course(String name, int num, int seatsAvailable, LinkedList kdamCourses) {
        this.name = name;
        courseNum = num;
        this.seatsAvailable = seatsAvailable;
        kdams = kdamCourses;
    }
    public boolean isAvailable() {
        return seatsAvailable>0;
    }

    public LinkedList getKdam() {
        return kdams;
    }

    public String getStats() {
    }
}
