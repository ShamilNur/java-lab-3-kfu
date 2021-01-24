package ru.kpfu.itis.group903.nurkaev.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class SocketClient {
    private final Socket client;
    private final PrintWriter toServer;
    private final BufferedReader fromServer;

    public SocketClient(InetAddress host, int port) {
        try {
//            Scanner scanner = new Scanner(System.in);
//            boolean isRegistered = false;
//            while (!isRegistered) {
//                System.out.print("Введите ник: ");
//                String nickName = scanner.nextLine();
//                toServer.sendMessage(new Message(Protocol.JOIN_REQUEST, nickName.getBytes()));
//                Message messageFromServer = fromServer.readMessage();
//                if (messageFromServer.getType() == Protocol.JOIN_RESPONSE) {
//                    System.out.println("Успешная регистрация.");
//                    isRegistered = true;
//                } else {
//                    System.out.println("Error.");
//                }
//            }
            client = new Socket(host, port);
            toServer = new PrintWriter(client.getOutputStream(), true);
            fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Runnable receiverMessagesTask = () -> {
                while (true) {
                    try {
                        String messageFromServer = fromServer.readLine();
                        if (messageFromServer != null) {
                            System.out.println(messageFromServer);
                        }
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                }
            };
            new Thread(receiverMessagesTask).start();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void sendMessage(String message) {
        toServer.println(message);
    }
}
