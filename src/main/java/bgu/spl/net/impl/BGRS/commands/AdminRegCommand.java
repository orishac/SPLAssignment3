package bgu.spl.net.impl.BGRS.commands;

import bgu.spl.net.srv.Admin;

public class AdminRegCommand extends ComplexCommand{

    public AdminRegCommand(String username, String password) {
        super(username, password);
        opcode = 1;
    }

    public Command act() {
        Admin admin = new Admin(this.username, this.password);
        if(database.adminRegister(this.username, this.password)) {
            //retunr ack
        }
        return new Err(1);
    }

}
