package wallpapersapp;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class WallpapersApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(ProgramNavigation.loadFXML("authorization"), 800, 430);
        ProgramNavigation.setScene(scene);
        stage.setTitle("Каталог картинок");
        stage.getIcons().add(new Image(WallpapersApp.class.getResourceAsStream("images/logo.png")));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
