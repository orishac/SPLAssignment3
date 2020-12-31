package bgu.spl.net.impl.BGRSServer.commands;

public class UnregisterCommand extends CourseNumCommand{

    public UnregisterCommand(int Coursenum) {
        super(Coursenum);
        opcode = 10;
    }

    public Command act() {
        if(database.unregister(this.CourseNum)) {
            return new Ack(10, "");
        }
        return new Err(10);
    }
}
