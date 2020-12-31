package bgu.spl.net.impl.BGRSServer.commands;

public class IsRegisteredCommand extends CourseNumCommand {

    public IsRegisteredCommand(int Coursenum) {
        super(Coursenum);
        opcode = 9;
    }

    public Command act() {
        if(database.isRegisterd(this.CourseNum)) {
            return new Ack(9, "");
        }
       return new Ack(9, "NOT REGISTERED");
    }
}
