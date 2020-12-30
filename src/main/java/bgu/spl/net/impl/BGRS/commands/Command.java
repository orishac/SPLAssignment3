package bgu.spl.net.impl.BGRS.commands;

import bgu.spl.net.srv.Database;

public abstract class Command {

    protected Database database = Database.getInstance();
    protected int opcode;
    public abstract Command act();
}
