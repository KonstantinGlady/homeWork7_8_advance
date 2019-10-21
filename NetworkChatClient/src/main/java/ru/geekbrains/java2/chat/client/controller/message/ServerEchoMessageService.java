package ru.geekbrains.java2.chat.client.controller.message;

import javafx.scene.control.TextArea;
import ru.geekbrains.java2.chat.client.controller.Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerEchoMessageService implements IMessageService {

    private final TextArea chatTextArea;
    private Network network;

    public ServerEchoMessageService(TextArea chatTextArea) {
        this.chatTextArea = chatTextArea;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    @Override
    public void sendMessage(String message) {
        network.send(message);
    }

    @Override
    public void processRetrievedMessage(String message) {
        chatTextArea.appendText(message + System.lineSeparator());
    }
}
