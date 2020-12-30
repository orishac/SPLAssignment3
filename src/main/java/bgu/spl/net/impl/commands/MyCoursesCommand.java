package bgu.spl.net.impl.commands;

public class MyCoursesCommand extends Command{

    public MyCoursesCommand() {
        opcode = 11;
    }

    public Command act() {
        database.getCourses();
    }
}
