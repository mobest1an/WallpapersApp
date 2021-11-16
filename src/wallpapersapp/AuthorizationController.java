package wallpapersapp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class AuthorizationController {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button authButton;
    @FXML
    private Button registrationButton;
    @FXML
    private Label message;

    public void initialize() {
        authButton.setOnAction(event -> { //вход в систему
            DataBaseManager dbManager = ContainerBean.getDbManager();
            ResultSet resultSet = dbManager.getUser(loginField.getText(), passwordField.getText());
            try {
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    message.setText("");
                    try {
                        if (id == 1) {
                            ProgramNavigation.setRoot("mainAdmin");
                        } else {
                            ContainerBean.setUserName(loginField.getText());
                            ProgramNavigation.setRoot("mainClient");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    message.setText("Такого пользователя не существует!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        registrationButton.setOnAction(event -> { //переход на страницу регистрации
            try {
                ProgramNavigation.setRoot("registration");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
