package main;
	
import java.io.IOException;

import javax.sound.midi.ControllerEventListener;

import model.Funcionarios;
import dataBase.BancoDeDados;
import view.AdminController;
import view.LoginController;
import view.RootController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp<T> extends Application {
	private Funcionarios logado = null;
	private BancoDeDados<T> dataBase = new BancoDeDados<T>();
	private Stage primaryStage;
    private BorderPane rootLayout;
    public RootController controller;
	public BancoDeDados getDB(){
		return this.dataBase;
	}

    
    
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Loja");
        ShowRootLayout();
        ShowLoginLayout();
        
	}
	
	
	public void ShowRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();     
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void ShowLoginLayout() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/LoginLayout.fxml"));
            AnchorPane loginlayout = (AnchorPane) loader.load();
            rootLayout.setCenter(loginlayout);
            LoginController controller2 = loader.getController();
            controller2.setMainApp(this);           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void ShowAdminLayout() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/AdminLayout.fxml"));
            AnchorPane adminlayout = (AnchorPane) loader.load();
            rootLayout.setCenter(adminlayout);
            AdminController controller3 = loader.getController();
            controller3.setMainApp(this);           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public boolean Logar(String user,String senha) {
		logado = dataBase.Login(user, senha);
		if(logado != null){
			ShowAdminLayout();
    		controller.menuBarLogar(logado.getuser());
    		return true;
    	}
		else{
			return false;
		}
		
    }
	
	public void DesLogar() {
		logado = null;
		controller.menuBarDeslogar();
		ShowLoginLayout();

    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
