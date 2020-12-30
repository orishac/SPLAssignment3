package bgu.spl.net.impl.BGRS.commands;

public class CourseStatCommand extends CourseNumCommand{

    public CourseStatCommand(int Coursenum) {
        super(Coursenum);
        opcode = 7;
    }

    public Command act() {
        database.courseStats(this.CourseNum) {
            //retunr ack
        }
    }
}
