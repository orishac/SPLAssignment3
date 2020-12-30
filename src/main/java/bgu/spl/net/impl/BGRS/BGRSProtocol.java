package bgu.spl.net.impl.BGRS;

import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.impl.BGRS.commands.Command;
import bgu.spl.net.impl.BGRS.commands.LogoutCommand;

public class BGRSProtocol implements MessagingProtocol<Command> {
    private boolean terminate = false;

    @Override
    public Command process(Command msg) {
        if (msg instanceof LogoutCommand) {
            terminate = true;
        }
        return msg.act();
    }

    @Override
    public boolean shouldTerminate() {
        return terminate;
    }
}