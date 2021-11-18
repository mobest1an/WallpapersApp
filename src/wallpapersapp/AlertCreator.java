package wallpapersapp;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertCreator {

    public Alert createAlert(ButtonType... buttonType) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("Выберите действие");
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(buttonType);
        return alert;
    }
}
