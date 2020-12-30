package bgu.spl.net.impl.BGRS.commands;

import bgu.spl.net.srv.Database;

public abstract class CourseNumCommand extends Command{

    protected Database database = Database.getInstance();
    protected int CourseNum;
    protected int opcode;

    public CourseNumCommand(int CourseNum) {
        this.CourseNum = CourseNum;
    }
}
