package ru.geekbrains.java2.chat.client.controller.message;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import ru.geekbrains.java2.chat.client.controller.Network;
import ru.geekbrains.java2.chat.client.controller.PrimaryController;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;


public class ServerMessageService implements IMessageService {


    private Timer timer;
    private static final String HOST_ADDRESS_PROP = "server.address";
    private static final String HOST_PORT_PROP = "server.port";
    public static final String STOP_SERVER_COMMAND = "/end";

    private String hostAddress;
    private int hostPort;

    private final TextArea chatTextArea;
    private PrimaryController primaryController;
    private boolean needStopServerOnClosed;
    private Network network;

    public ServerMessageService(PrimaryController primaryController, boolean needStopServerOnClosed) {
        this.chatTextArea = primaryController.chatTextArea;
        this.primaryController = primaryController;
        this.needStopServerOnClosed = needStopServerOnClosed;
        initialize();
    }

    private void initialize() {
        readProperties();
        startConnectionToServer();
        startTimerForConnection();

    }

    private void startTimerForConnection() {
        new Thread(() -> {

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (primaryController.authPanel.isVisible()) {
                       // System.out.println("time is out");

                        try {
                            network.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            primaryController.closeWindow();
                        }

                    }
                }
            };

            timer = new Timer();
            timer.schedule(task, 120000);

        }).start();
    }



    private void startConnectionToServer() {
        try {
            this.network = new Network(hostAddress, hostPort, this);
        } catch (IOException e) {
            throw new ServerConnectionException("Failed to connect to server", e);
        }
    }

    private void readProperties() {
        Properties serverProperties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream("/application.properties")) {
            serverProperties.load(inputStream);
            hostAddress = serverProperties.getProperty(HOST_ADDRESS_PROP);
            hostPort = Integer.parseInt(serverProperties.getProperty(HOST_PORT_PROP));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read application.properties file", e);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid port value", e);
        }
    }

    @Override
    public void sendMessage(String message) {
        network.send(message);
    }

    @Override
    public void processRetrievedMessage(String message) {
        if (message.startsWith("/authok")) {
            takeLastMessage();
            primaryController.authPanel.setVisible(false);
            primaryController.chatPanel.setVisible(true);
        } else if (primaryController.authPanel.isVisible()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Authentication is failed");
            alert.setContentText(message);
            alert.showAndWait();
        } else {
            chatTextArea.appendText("Сервер: " + message + System.lineSeparator());
        }
    }

    private void takeLastMessage() {
        String userName = primaryController.loginField.getText();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(
                                new File("usersStores/"+userName+".usr")));
            String str;
            while ((str = bf.readLine()) != null){
                primaryController.chatTextArea.appendText(str + System.lineSeparator());
            }
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        safeLastMessage();
        if (needStopServerOnClosed) {
            sendMessage(STOP_SERVER_COMMAND);
        }
        network.close();
    }

    private void safeLastMessage()  {

       TextArea textArea = primaryController.chatTextArea;

        while (textArea.getText().split("\n",-1).length > 201){
            int line = textArea.getText().indexOf("\n");
            textArea.replaceText(0,line+1,"");
        }


        String userName = primaryController.loginField.getText();
        ObservableList<CharSequence> observableList = textArea.getParagraphs();

        Iterator<CharSequence> iterator = observableList.iterator();

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new
                        FileWriter(new File("usersStores/"+userName+".usr")));
            while (iterator.hasNext()){
                CharSequence sequence = iterator.next();
                bufferedWriter.append(sequence);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
