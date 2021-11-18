package wallpapersapp;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class OpenImageController {

    @FXML
    private ImageView image;

    public void initialize() {
        image.setImage(ContainerBean.getOpenedImage());
    }
}
