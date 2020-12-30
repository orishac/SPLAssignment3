package bgu.spl.net.impl.BGRS.commands;

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
