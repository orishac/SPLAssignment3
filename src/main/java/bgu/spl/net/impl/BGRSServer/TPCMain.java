package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.srv.Database;
import bgu.spl.net.srv.Server;

public class TPCMain {

    public static void main(String[] args) {

        Server.threadPerClient(
                7777, //port
                () -> new BGRSProtocol(), //protocol factory
                BGRSEncoderDecoder::new //message encoder decoder factory
        ).serve();
    }
}
