package wallpapersapp;

import java.sql.*;

public class DataBaseManager { //класс для работы с базой данных

    private final String URL = "jdbc:mysql://localhost:3306/wallpapersappdb";
    private final String USER = "root";
    private final String PASS = "wnc702";
    private Connection connection;

    public DataBaseManager() { //установка соединения
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addUser(String login, String password) { //добавление нового пользователя
        try {
            String query = "INSERT INTO users(user_login, user_password) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public ResultSet getUser(String login, String password) { //получение пользователя
        try {
            String query = "SELECT * FROM users WHERE user_login=? AND user_password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
