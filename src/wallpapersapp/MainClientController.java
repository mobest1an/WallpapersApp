package wallpapersapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainClientController {

    @FXML
    private Button exitButton;
    @FXML
    private Label userName;

    public void initialize() {
        userName.setText(ContainerBean.getUserName());
        exitButton.setOnAction(event -> {
            try {
                ProgramNavigation.setRoot("authorization");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
