package bgu.spl.net.impl.BGRSServer.commands;

public class Err extends Command{

    private int messageOpcode;

    public Err(int messageOpCode) {
        opcode = 13;
        messageOpcode = messageOpCode;
    }

    @Override
    public Command act() {
        return null;
    }
}
