package ru.geekbrains.java2.controller.message;

public interface IMessageProcessor {

    void sendMessage(String message);

    void processRetrievedMessage(String message);
}
