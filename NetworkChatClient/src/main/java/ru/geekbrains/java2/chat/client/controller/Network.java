package ru.geekbrains.java2.chat.client.controller;

import javafx.application.Platform;
import ru.geekbrains.java2.chat.client.controller.message.IMessageService;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network implements Closeable {

    private final Socket socket;
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public Network(String serverAddress, int port, IMessageService messageService) throws IOException {
        this.socket = new Socket(serverAddress, port);
        this.inputStream  = new DataInputStream(socket.getInputStream());
        this.outputStream = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            while (true) {
                try {
                    String message = inputStream.readUTF();
                    Platform.runLater(() -> messageService.processRetrievedMessage(message));
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }).start();
    }


    public void send(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException("Failed to send message: " + message);
        }
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}
