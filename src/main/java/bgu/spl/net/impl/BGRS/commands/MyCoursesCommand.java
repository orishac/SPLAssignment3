package bgu.spl.net.impl.BGRS.commands;

public class MyCoursesCommand extends Command{

    public MyCoursesCommand() {
        opcode = 11;
    }

    public Command act() {
        database.getCourses();
    }
}
