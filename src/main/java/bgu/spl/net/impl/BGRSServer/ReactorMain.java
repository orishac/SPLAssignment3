package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.impl.newsfeed.NewsFeed;
import bgu.spl.net.impl.rci.ObjectEncoderDecoder;
import bgu.spl.net.impl.rci.RemoteCommandInvocationProtocol;
import bgu.spl.net.srv.Database;
import bgu.spl.net.srv.Server;

public class ReactorMain {
    public static void main(String[] args) {
        Server.reactor(
                Runtime.getRuntime().availableProcessors(),
                7777, //port
                () ->  new BGRSProtocol(), //protocol factory
                BGRSEncoderDecoder::new //message encoder decoder factory
        ).serve();
    }
}
