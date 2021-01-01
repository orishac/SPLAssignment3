package bgu.spl.net.impl.BGRSServer.commands;

import bgu.spl.net.srv.Database;

public abstract class CourseNumCommand extends Command{

    protected Database database = Database.getInstance();
    protected int opcode;

    public CourseNumCommand(int CourseNum) {
        this.CourseNum = CourseNum;
    }
}
