package bgu.spl.net.impl.BGRSServer.commands;

import bgu.spl.net.srv.Database;

public abstract class ComplexCommand extends Command{

    public ComplexCommand (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }


}
