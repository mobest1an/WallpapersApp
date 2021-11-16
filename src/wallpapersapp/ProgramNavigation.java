package wallpapersapp;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ProgramNavigation { //класс для навигации между страницами
    private static Scene scene;

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        ProgramNavigation.scene = scene;
    }
    
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WallpapersApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
