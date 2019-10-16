package ru.geekbrains.java2.controller.message;

import javafx.scene.control.TextArea;

public class MockMessageProcessor implements IMessageProcessor {

    private TextArea chatTextArea;

    public MockMessageProcessor(TextArea chatTextArea) {
        this.chatTextArea = chatTextArea;
    }

    @Override
    public void sendMessage(String message) {
        System.out.printf("Message %s has been sent%n", message);
        processRetrievedMessage(message);
    }

    @Override
    public void processRetrievedMessage(String message) {
        chatTextArea.appendText(message + System.lineSeparator());
    }
}
