package wallpapersapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainAdminController {

    @FXML
    private Button exitButton;
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
    @FXML
    private ImageView image_10;
    @FXML
    private ImageView image_11;
    @FXML
    private ImageView image_12;
    @FXML
    private ImageView image_13;
    @FXML
    private ImageView image_14;
    @FXML
    private ImageView image_15;

    public void initialize() {
        addHandlers(image_1, image_2, image_3, image_4, image_5, image_6, image_7, image_8, image_9, image_10, image_11, image_12, image_13, image_14, image_15);

        exitButton.setOnAction(event -> {
            try {
                ProgramNavigation.setRoot("authorization");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void addHandlers(ImageView... imageViews) {
        for (ImageView imageView : imageViews) {
            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                ContainerBean.getWallpapersActions().openMenu(imageView.getImage());
            });
        }
    }
}
