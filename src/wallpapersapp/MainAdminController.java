package wallpapersapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainAdminController {

    @FXML
    private Button exitButton;

    public void initialize() {
        exitButton.setOnAction(event -> {
            try {
                ProgramNavigation.setRoot("authorization");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
