package bgu.spl.net.impl.commands;

import bgu.spl.net.srv.Database;

public class ComplexCommand {

    protected Database database = Database.getInstance();
    protected String username;
    protected String password;
    protected int opcode;

    public ComplexCommand (String username, String password) {
        this.username = username;
        this.password = password;
    }


}
