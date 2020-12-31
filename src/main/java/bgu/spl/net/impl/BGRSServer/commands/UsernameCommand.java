package bgu.spl.net.impl.BGRSServer.commands;

import bgu.spl.net.srv.Database;

public abstract class UsernameCommand extends Command{

    protected Database database = Database.getInstance();
    protected String username;
    protected int opcode;

    public UsernameCommand (String username) {
        this.username = username;
    }

}
