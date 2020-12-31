package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.impl.BGRSServer.commands.Command;
import bgu.spl.net.impl.BGRSServer.commands.LogoutCommand;
import bgu.spl.net.srv.Database;

public class BGRSProtocol implements MessagingProtocol<Command> {
    private boolean terminate = false;
    private Database database = Database.getInstance();

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
