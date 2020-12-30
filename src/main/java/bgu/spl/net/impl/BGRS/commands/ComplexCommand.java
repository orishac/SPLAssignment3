package bgu.spl.net.impl.BGRS.commands;

import bgu.spl.net.srv.Database;

public abstract class ComplexCommand extends Command{

    protected Database database = Database.getInstance();
    protected String username;
    protected String password;
    protected int opcode;

    public ComplexCommand (String username, String password) {
        this.username = username;
        this.password = password;
    }


}
