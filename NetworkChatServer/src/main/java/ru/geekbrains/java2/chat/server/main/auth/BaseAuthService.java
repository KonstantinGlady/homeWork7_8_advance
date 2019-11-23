package ru.geekbrains.java2.chat.server.main.auth;

import java.util.List;
import java.sql.*;

public class BaseAuthService implements AuthService {

    Connection connection = null;
    Statement stmt;
/*    private static class Entry {
        private String login;
        private String password;
        private String nick;

        public Entry(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }
    }

    private final List<Entry> entries = List.of(
            new Entry("login1", "pass1", "nick1"),
            new Entry("login2", "pass2", "nick2"),
            new Entry("login3", "pass3", "nick3")
    );*/


    @Override
    public void start() {

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:/SQLiteBase/mydatabase.db";

            connection = DriverManager.getConnection(url);

            System.out.println("Auth service is running");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void stop() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Auth service has stopped");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public String getNickByLoginPass(String login, String password) {
      /*  for (Entry entry : entries) {
            if (entry.login.equals(login) && entry.password.equals(pass)) {
                return entry.nick;
            }
        }

        return null;*/
        String nick = null;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select nick from ac_table where login = ? and pass = ?");
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                nick = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(nick);
        return nick;
    }
}
