package bgu.spl.net.impl.BGRSServer.commands;

import bgu.spl.net.srv.Student;

public class StudentRegCommand extends ComplexCommand{

    public StudentRegCommand(String username, String password) {
        super(username, password);
        opcode = 2;
    }

    public Command act() {
        Student admin = new Student(this.username, this.password);
        if(database.studentRegister(this.username, this.password)) {
            return new Ack(2, "");
        }
        return new Err(2);
    }
}
