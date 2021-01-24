package ru.kpfu.itis.group903.nurkaev;

import ru.kpfu.itis.group903.nurkaev.client.SocketClient;
import ru.kpfu.itis.group903.nurkaev.network.Protocol;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class MainForClient {
    public static void main(String[] args) throws UnknownHostException {
        SocketClient client = new SocketClient(InetAddress.getByName("localhost"), Protocol.PORT);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            client.sendMessage(message);
        }
    }
}
