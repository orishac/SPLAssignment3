package bgu.spl.net.impl.commands;

import bgu.spl.net.srv.Admin;

public class LogoutCommand extends Command{
    public LogoutCommand() {
        opcode = 4;
    }

    public Command act() {
        if(database.logout()) {
            //retunr ack
        }
        return new Err(4);
    }
}
