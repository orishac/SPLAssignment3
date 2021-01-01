package bgu.spl.net.impl.BGRSServer.commands;

import bgu.spl.net.srv.Database;

public abstract class Command {

    protected Database database = Database.getInstance();
    protected int opcode;
    protected String username;
    protected String password;
    protected int CourseNum;


    public abstract Command act();

    public int getOpcode() {
        return opcode;
    }

    public String getUsername() {
        return username;
    }

    public int getCourseNum() {
        return CourseNum;
    }

    public String getPassword() {
        return password;
    }
}
