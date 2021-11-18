package wallpapersapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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

        image_1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_1.getImage(), 1);
        });

        image_2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_2.getImage(), 2);
        });

        image_3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_3.getImage(), 3);
        });

        image_4.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_4.getImage(), 4);
        });

        image_5.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_5.getImage(), 5);
        });

        image_6.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_6.getImage(), 6);
        });

        image_7.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_7.getImage(), 7);
        });

        image_8.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_8.getImage(), 8);
        });

        image_9.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_9.getImage(), 9);
        });

        exitButton.setOnAction(event -> {
            try {
                ProgramNavigation.setRoot("authorization");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
