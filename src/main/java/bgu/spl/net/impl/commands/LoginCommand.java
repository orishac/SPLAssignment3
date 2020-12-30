package bgu.spl.net.impl.commands;

import bgu.spl.net.impl.rci.Command;

public class LoginCommand extends ComplexCommand {
    public LoginCommand(String username, String password) {
        super (username, password);
        opcode = 3;
    }

    public Command act() {
        if(database.login(username,password)) {
            //return ack
        }
        return //err
    }
}
