package bgu.spl.net.srv;

import java.util.LinkedList;

public class Student extends User{

    private LinkedList<Course> courseslist;

    public Student(String username, String password) {
        super(username, password);
    }

    public String getStats() {
        String ret= "Student" + super.getUsername()+"\n"
                +"Courses:" + "[" +courseslist.toString() + "]";
        return ret;
    }
}

