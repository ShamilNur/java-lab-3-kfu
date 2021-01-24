package ru.kpfu.itis.group903.nurkaev.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class EchoServerSocket {
    private final List<ClientHandler> clientHandlers;
    private final List<String> clientNickNames;

    public EchoServerSocket() {
        clientHandlers = new CopyOnWriteArrayList<>();
        clientNickNames = new ArrayList<>();
    }

    public boolean register(String newNickName) {
        for (String nickName : clientNickNames) {
            if (newNickName.equals(nickName)) {
                return false;
            }
        }
        clientNickNames.add(newNickName);
        return true;
    }

    public void start(int port) {
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            while (true) {
                // accept() уводит приложение в ожидание до подключения клиента,
                // после подключения клиента поток продолжает выполнение
                // и помещает "клиента" в client
                Socket client = server.accept();
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private class ClientHandler extends Thread {

        private final Socket client;

        public ClientHandler(Socket client) {
            this.client = client;
            clientHandlers.add(this);
            //TODO: вместо порта печатать никнейм
            System.out.println("New client " + client.getPort());
        }

        @Override
        public void run() {
            try (BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                String messageFromClient;
                while ((messageFromClient = fromClient.readLine()) != null) {
                    //выводим сообщение для клиента, который отправил сообщение (отправителю)
                    System.out.println(client.getPort() + ": " + messageFromClient);
                    //отсылаем сообщение всем другим клиентам (получателям)
                    for (ClientHandler clientHandler : clientHandlers) {
                        PrintWriter toClient = new PrintWriter(clientHandler.client.getOutputStream(), true);
                        //TODO: вместо порта печатать никнейм
                        toClient.println(client.getPort() + ": " + messageFromClient);
                    }
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }

    }
}
