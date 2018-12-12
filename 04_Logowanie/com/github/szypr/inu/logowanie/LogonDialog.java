package com.github.szypr.inu.logowanie;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class LogonDialog{
	private Stage stage= new Stage();
	
	private Label label1= new Label("Logowanie do Systemu");
	private Label label2= new Label("Środowisko");
	private Label label3= new Label("Użytkownik");
	private Label label4= new Label("Hasło");
	private ChoiceBox<String> cbxEnv= new ChoiceBox<String>();
	private ComboBox<String> cbxUsers= new ComboBox<String>();
	private PasswordField passField= new PasswordField();
	private Button loginBtn= new Button("Loguj");
	private Button cancelBtn= new Button("Anuluj");
	private HBox hBox1= new HBox();
	private HBox hBox2= new HBox();
	private HBox hBox3= new HBox();
	private HBox hBox4= new HBox();
	private HBox hBox5= new HBox();
	private VBox vBox= new VBox();
	private Scene scene= new Scene(vBox, 500, 300);
	
	
	LogonDialog(){
		setLayout();
		setBox();
		stage.setScene(scene);
		stage.setTitle("Logowanie");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
	}
	void setLayout(){
		hBox1.getChildren().add(label1);
		hBox2.getChildren().addAll(label2, cbxEnv);
		hBox3.getChildren().addAll(label3, cbxUsers);
		hBox4.getChildren().addAll(label4, passField);
		hBox5.getChildren().addAll(loginBtn, cancelBtn);
		vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5);
		vBox.setPadding(new Insets(10));
		vBox.setSpacing(10);
		cbxEnv.setPrefWidth(200);
		setPosition();
	}
	void setBox(){
		cbxEnv.getItems().addAll("Produkcyjne", "Testowe", "Deweloperskie");
		cbxEnv.setValue("Produkcyjne");
		cbxUsers.getItems().addAll("Zielon M&M", "Niebieski M&M", "Czerwony M&M", "Żółty M&M");
		cbxUsers.setEditable(true);
		cbxUsers.setVisibleRowCount(3);
	}
	void setPosition(){
		hBox1.setAlignment(Pos.TOP_CENTER);
		hBox2.setAlignment(Pos.TOP_CENTER);
		hBox3.setAlignment(Pos.TOP_CENTER);
		hBox4.setAlignment(Pos.TOP_CENTER);
		hBox5.setAlignment(Pos.TOP_CENTER);
	}
}
