package bgu.spl.net.impl.BGRS.commands;

public class StudentStatCommand extends UsernameCommand {

    public StudentStatCommand(String username) {
        super(username);
        opcode = 8;
    }

    public Command act() {
        database.studentStats(this.username)) {
            //retunr ack
        }

    }
}
