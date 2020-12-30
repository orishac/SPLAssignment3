package bgu.spl.net.impl.BGRS.commands;

public class UnregisterCommand extends CourseNumCommand{

    public UnregisterCommand(int Coursenum) {
        super(Coursenum);
        opcode = 10;
    }

    public Command act() {
        if(database.unregister(this.CourseNum) {
            //retunr ack
        }
        return new Err(10);
    }
}
