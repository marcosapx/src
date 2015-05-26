package view;

import java.awt.MenuItem;

import main.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class RootController {
	@FXML
    private Menu menuLogin;
	@FXML
	private javafx.scene.control.MenuItem deslogar;

	
    private MainApp mainApp;
    
    public RootController() {
    }


    @FXML
    private void initialize() {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void menuBarLogar(String user) {
        deslogar.setVisible(true);
        menuLogin.setText("Logado:"+user);
    }
    
    public void menuBarDeslogar() {
    	deslogar.setVisible(false);
    	menuLogin.setText("Login");
    }
    
    
    
    @FXML
    private void bndeslogar() {
    	mainApp.DesLogar();
    }


}