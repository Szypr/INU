package com.github.szypr.inu.logowanie;
	
import javafx.application.Application;
import javafx.stage.Stage;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new LogonDialog();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
