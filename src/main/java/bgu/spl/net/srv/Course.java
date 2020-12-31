package bgu.spl.net.srv;

import java.util.Comparator;
import java.util.LinkedList;

public class Course {

    private String name;
    private int courseNum;
    private int seatsAvailable;
    private LinkedList<Integer> kdams;
    private LinkedList<String> studentRegisterd;

    public Course(String name, int num, int seatsAvailable, LinkedList kdamCourses) {
        this.name = name;
        courseNum = num;
        this.seatsAvailable = seatsAvailable;
        kdams = kdamCourses;
        studentRegisterd = new LinkedList<>();
    }
    public boolean isAvailable() {
        return seatsAvailable>0;
    }

    public String getKdam() {
        return kdams.toString();
    }

    public String getStats() {
        return "Course:" + name+"\n"
                +"Seats Available:" + seatsAvailable + "\n"
                +"Student Registered:"+studentRegisterd.toString();
    }

    public boolean checkIfStudentRegistered(String username) {
        return studentRegisterd.contains(username);
    }

    public boolean deleteStudent(String username) {
        return studentRegisterd.remove(username);
    }
}
