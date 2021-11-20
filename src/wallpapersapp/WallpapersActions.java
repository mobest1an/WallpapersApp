package wallpapersapp;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public void openMenu(Image image, int index) {
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
                try {
                    open(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (optional.get().equals(installButton)) {
                install(index);
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

    private void open(Image image) throws IOException {
        ContainerBean.setOpenedImage(image);
        FXMLLoader fxmlLoader = new FXMLLoader(WallpapersApp.class.getResource("openImage.fxml"));
        Parent root = fxmlLoader.load();
        Stage newStage = new Stage();
        newStage.setTitle("Просмотр изображения");
        newStage.getIcons().add(new Image(WallpapersApp.class.getResourceAsStream("images/logo.png")));
        newStage.setScene(new Scene(root, 950, 530));
        newStage.setResizable(false);
        newStage.show();
    }

    private void install(int index) {
        String path = "C:\\Users\\erikk\\NetBeansProjects\\WallpapersApp\\src\\wallpapersapp\\images\\image" + index + ".jpg";
        ContainerBean.getWallpaperChanger().changeWallpaper(path);
    }
}
