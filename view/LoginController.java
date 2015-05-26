package view;

import main.MainApp;
import model.Funcionarios;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class LoginController {

    @FXML
    private TextField user;
    @FXML
    private PasswordField senha;
    @FXML
    private Label loginStatus;

	
	
    private MainApp mainApp;
    
    public LoginController() {
    }


    @FXML
    private void initialize() {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
        
    @FXML
    private void ActBnLogin() {
    	if(user.getText().equals("") || senha.getText().equals("")){
    		loginStatus.setText("Não pode ter campos em branco");
    	}
    	else if((!mainApp.Logar(user.getText(),senha.getText()))){
    		loginStatus.setText("Usuario ou senha errada");
    	}
    }

}