package ru.geekbrains.java2.chat.client.controller.message;

public interface IMessageService {

    void sendMessage(String message);

    void processRetrievedMessage(String message);
}
