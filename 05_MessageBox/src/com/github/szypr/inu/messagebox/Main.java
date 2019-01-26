package com.github.szypr.inu.messagebox;
	

import com.github.szypr.inu.messagebox.Show.MessageBoxButton;
import com.github.szypr.inu.messagebox.Show.MessageBoxIcon;

import javafx.application.Application;
import javafx.stage.Stage;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		Show.show("Tutaj wpisz tekst wiadomoœci", "TYTU£ OKIENKA", MessageBoxIcon.Information, MessageBoxButton.OkCancel);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
