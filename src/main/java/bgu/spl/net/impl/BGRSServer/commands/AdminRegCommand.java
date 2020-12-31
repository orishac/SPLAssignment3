package bgu.spl.net.impl.BGRSServer.commands;

import bgu.spl.net.srv.Admin;

public class AdminRegCommand extends ComplexCommand{

    public AdminRegCommand(String username, String password) {
        super(username, password);
        opcode = 1;
    }

    public Command act() {
        Admin admin = new Admin(this.username, this.password);
        if(database.adminRegister(this.username, this.password)) {
            return new Ack(1, "");
        }
        return new Err(1);
    }

}
