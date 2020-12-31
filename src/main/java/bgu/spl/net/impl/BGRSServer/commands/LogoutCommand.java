package bgu.spl.net.impl.BGRSServer.commands;

public class LogoutCommand extends Command{
    public LogoutCommand() {
        opcode = 4;
    }

    public Command act() {
        if(database.logout()) {
            return new Ack(4, "");
        }
        return new Err(4);
    }
}
