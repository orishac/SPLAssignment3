package bgu.spl.net.impl.BGRSServer.commands;

public class CourseStatCommand extends CourseNumCommand{

    public CourseStatCommand(int Coursenum) {
        super(Coursenum);
        opcode = 7;
    }

    public Command act() {
        String toSend = database.courseStats(this.CourseNum);
        return new Ack(7, toSend);
        }
    }

