package view;

import main.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class AdminController {


    private MainApp mainApp;


    public AdminController() {
    }


    @FXML
    private void initialize() {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;


    }
    


}