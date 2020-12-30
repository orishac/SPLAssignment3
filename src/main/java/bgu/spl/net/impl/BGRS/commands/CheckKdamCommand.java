package bgu.spl.net.impl.BGRS.commands;

public class CheckKdamCommand extends CourseNumCommand{

    public CheckKdamCommand(int Coursenum) {
        super(Coursenum);
        opcode = 6;
    }

    public Command act() {
        if(database.KdamCheck(this.CourseNum)) {
            //retunr ack
        }
        return new Err(6);
    }
}
