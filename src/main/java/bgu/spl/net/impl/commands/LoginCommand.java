package bgu.spl.net.impl.commands;

public class LoginCommand extends ComplexCommand {
    public LoginCommand(String username, String password) {
        super (username, password);
        opcode = 3;
    }

    public Command act() {
        if(database.login(username,password)) {
            //return ack
        }
        return new Err(3);
    }
}
