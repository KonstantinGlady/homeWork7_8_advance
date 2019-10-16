package ru.geekbrains.java2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.geekbrains.java2.controller.message.IMessageProcessor;
import ru.geekbrains.java2.controller.message.MockMessageProcessor;

public class PrimaryController implements Initializable {

    public @FXML TextArea chatTextArea;
    public @FXML TextField messageText;
    public @FXML Button sendMessageButton;

    private IMessageProcessor messageProcessor;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.messageProcessor = new MockMessageProcessor(chatTextArea);
    }

    @FXML
    public void sendText(ActionEvent actionEvent) {
        sendMessage();
    }

    @FXML
    public void sendMessage(ActionEvent actionEvent) {
        sendMessage();
    }

    private void sendMessage() {
        String message = messageText.getText();
        messageProcessor.sendMessage(message);
        messageText.clear();
    }
}
