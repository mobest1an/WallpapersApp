package wallpapersapp;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

public class WallpapersActions {

    public void openMenu(Image image) {
        ButtonType saveButton = new ButtonType("Save");
        ButtonType openButton = new ButtonType("Open");
        ButtonType installButton = new ButtonType("Install");
        ButtonType closeButton = ButtonType.CLOSE;
        Alert alert = ContainerBean.getAlertCreator().createAlert(saveButton, openButton, installButton, closeButton);
        Optional<ButtonType> optional = alert.showAndWait();
        if (optional.isPresent()) {
            if (optional.get().equals(saveButton)) {
                try {
                    save(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (optional.get().equals(openButton)) {

            } else if (optional.get().equals(installButton)) {

            }
        }
    }

    private void save(Image image) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранение файла");
        FileChooser.ExtensionFilter newFilter = new FileChooser.ExtensionFilter("Фотография (*.jpg)", "*.jpg");
        fileChooser.getExtensionFilters().add(newFilter);
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            fileChooser.setInitialDirectory(file);
            String savePath = fileChooser.getInitialDirectory().toString();
            FileOutputStream fileOutputStream = new FileOutputStream(savePath);
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
            ImageIO.write(bufferedImage, "jpg", fileOutputStream);
            fileOutputStream.close();
        }
    }
}
