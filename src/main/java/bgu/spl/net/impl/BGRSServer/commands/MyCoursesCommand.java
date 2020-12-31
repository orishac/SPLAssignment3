package bgu.spl.net.impl.BGRSServer.commands;

public class MyCoursesCommand extends Command{

    public MyCoursesCommand() {
        opcode = 11;
    }

    public Command act() {
        database.getCourses();
        return new Ack(11, "");
    }
}
