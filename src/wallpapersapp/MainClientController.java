package wallpapersapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainClientController {

    @FXML
    private Button exitButton;
    @FXML
    private Label userName;
    @FXML
    private ImageView image_1;
    @FXML
    private ImageView image_2;
    @FXML
    private ImageView image_3;
    @FXML
    private ImageView image_4;
    @FXML
    private ImageView image_5;
    @FXML
    private ImageView image_6;
    @FXML
    private ImageView image_7;
    @FXML
    private ImageView image_8;
    @FXML
    private ImageView image_9;

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
