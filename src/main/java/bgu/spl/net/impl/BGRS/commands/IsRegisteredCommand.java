package bgu.spl.net.impl.BGRS.commands;

public class IsRegisteredCommand extends CourseNumCommand {

    public IsRegisteredCommand(int Coursenum) {
        super(Coursenum);
        opcode = 9;
    }

    public Command act() {
        if(database.isRegisterd(this.CourseNum) {
            //retunr registered
        }
        //return not registered
    }
}
