package bgu.spl.net.impl.BGRSServer.commands;

public class LoginCommand extends ComplexCommand {
    public LoginCommand(String username, String password) {
        super (username, password);
        opcode = 3;
    }

    public Command act() {
        if(database.login(username,password)) {
            return new Ack(3, "");
        }
        return new Err(3);
    }
}
