package bgu.spl.net.impl.BGRS.commands;

public class Ack extends Command {

    private int messageOpcode;
    private String toSend;

    public Ack(int messageOpCode, String toSend) {
        opcode = 12;
        messageOpcode = messageOpCode;
        this.toSend = toSend;
    }

}
