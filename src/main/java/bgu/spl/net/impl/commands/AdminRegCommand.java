package bgu.spl.net.impl.commands;

import bgu.spl.net.impl.rci.Command;
import bgu.spl.net.srv.Database;

public class AdminRegCommand extends ComplexCommand{

    public AdminRegCommand(String username, String password) {
        super(username, password);
        opcode = 1;
    }

    public Command act() {
        AdminInfo admin = new AdminInfo(this.password);
        if(database.adminRegister(this.username, this.password)) {
            //retunr ack
        }
        return //error

    }

}
