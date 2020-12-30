package bgu.spl.net.impl.BGRS.commands;

public class RegisterCommand extends CourseNumCommand{

    public RegisterCommand(int Coursenum) {
        super(Coursenum);
        opcode = 5;
    }

    public Command act() {
        if(database.courseReg(this.CourseNum)) {
            //retunr ack
        }
        return new Err(5);
    }
}
