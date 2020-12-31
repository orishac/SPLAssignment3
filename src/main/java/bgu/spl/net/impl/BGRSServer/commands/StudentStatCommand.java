package bgu.spl.net.impl.BGRSServer.commands;

public class StudentStatCommand extends UsernameCommand {

    public StudentStatCommand(String username) {
        super(username);
        opcode = 8;
    }

    public Command act() {
        String toSend = database.studentStats(this.username);
        return new Ack(8, toSend);
    }
}
