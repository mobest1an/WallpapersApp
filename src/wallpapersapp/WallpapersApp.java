package wallpapersapp;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WallpapersApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(ProgramNavigation.loadFXML("authorization"), 800, 430);
        ProgramNavigation.setScene(scene);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
}
