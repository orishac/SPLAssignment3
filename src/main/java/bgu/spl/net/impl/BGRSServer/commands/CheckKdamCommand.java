package bgu.spl.net.impl.BGRSServer.commands;

public class CheckKdamCommand extends CourseNumCommand{

    public CheckKdamCommand(int Coursenum) {
        super(Coursenum);
        opcode = 6;
    }

    public Command act() {
        String toSend = database.KdamCheck(this.CourseNum);
        return new Ack(6, toSend);
    }
}

