package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.impl.BGRSServer.commands.Ack;
import bgu.spl.net.impl.BGRSServer.commands.Command;
import bgu.spl.net.impl.BGRSServer.commands.Err;
import bgu.spl.net.impl.BGRSServer.commands.LogoutCommand;
import bgu.spl.net.srv.Database;
import bgu.spl.net.srv.User;

public class BGRSProtocol implements MessagingProtocol<Command> {
    private boolean terminate = false;
    private Database database = Database.getInstance();
    private String loggedIn = null;

    @Override
    public Command process(Command msg) {
        switch (msg.getOpcode()) {
            case 1:
                if (database.adminRegister(msg.getUsername(), msg.getPassword())) {
                    return new Ack(1, "");
                }
                return new Err(1);
            case 2:
                if(database.studentRegister(msg.getUsername(), msg.getPassword())) {
                    return new Ack(2, "");
                }
                return new Err(2);
            case 3:
                if(database.login(msg.getUsername(),msg.getPassword())) {
                    loggedIn = msg.getUsername();
                    return new Ack(3, "");
                }
                return new Err(3);
            case 4:
                if(database.logout(loggedIn)) {
                    loggedIn = null;
                    terminate = true;
                    return new Ack(4, "");
                }
                return new Err(4);
            case 5:
                if(database.courseReg(msg.getCourseNum())) {
                    return new Ack(5, "");
                }
                return new Err(5);
            case 6:
                String kdamCheck = database.KdamCheck(msg.getCourseNum());
                return new Ack(6, kdamCheck);
            case 7:
                String courseStats = database.courseStats(msg.getCourseNum());
                return new Ack(7, courseStats);
            case 8:
                String studentStats = database.studentStats(msg.getUsername());
                return new Ack(8, studentStats);
            case 9:
                if(database.isRegisterd(msg.getCourseNum())) {
                    return new Ack(9, "");
                }
                return new Ack(9, "NOT REGISTERED");
            case 10:
                if(database.unregister(msg.getCourseNum())) {
                    return new Ack(10, "");
                }
                return new Err(10);
            case 11:
                database.getCourses();
                return new Ack(11, "");
        }
        return null;
    }

    @Override
    public boolean shouldTerminate() {
        return terminate;
    }
}
