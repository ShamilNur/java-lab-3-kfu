package ru.kpfu.itis.group903.nurkaev.server;

import ru.kpfu.itis.group903.nurkaev.network.Protocol;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class MainForServer {
    public static void main(String[] argv) {
        /*Args args = new Args();
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);
        EchoServerSocket serverSocket1 = new EchoServerSocket();
        serverSocket1.start(args.port);
*/
        EchoServerSocket serverSocket = new EchoServerSocket();
        serverSocket.start(Protocol.PORT);
    }
}
