package bgu.spl.net.impl.BGRSServer.commands;

public class RegisterCommand extends CourseNumCommand{

    public RegisterCommand(int Coursenum) {
        super(Coursenum);
        opcode = 5;
    }

    public Command act() {
        if(database.courseReg(this.CourseNum)) {
            return new Ack(5, "");
        }
        return new Err(5);
    }
}
