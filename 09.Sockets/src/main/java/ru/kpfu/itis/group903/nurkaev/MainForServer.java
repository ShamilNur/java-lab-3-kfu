package ru.kpfu.itis.group903.nurkaev;

import ru.kpfu.itis.group903.nurkaev.network.Protocol;
import ru.kpfu.itis.group903.nurkaev.server.EchoServerSocket;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class MainForServer {
    public static void main(String[] args) {
        EchoServerSocket serverSocket = new EchoServerSocket();
        serverSocket.start(Protocol.PORT);
    }
}
