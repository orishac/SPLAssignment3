package bgu.spl.net.impl.commands;

import bgu.spl.net.srv.Admin;
import bgu.spl.net.srv.Database;

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
