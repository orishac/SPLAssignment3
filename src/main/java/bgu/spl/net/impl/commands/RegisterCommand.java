package bgu.spl.net.impl.commands;

import bgu.spl.net.srv.Admin;

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
