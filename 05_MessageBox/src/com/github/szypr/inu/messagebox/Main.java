package com.github.szypr.inu.messagebox;
	

import com.github.szypr.inu.messagebox.Show.MessageBoxButton;
import com.github.szypr.inu.messagebox.Show.MessageBoxIcon;
import com.github.szypr.inu.messagebox.Show.MessageBoxResult;

import javafx.application.Application;
import javafx.stage.Stage;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		Show.show("Tutaj wpisz tekst wiadomości", "TYTUŁ OKIENKA", MessageBoxIcon.Information, MessageBoxButton.OkCancel);
		MessageBoxResult result = Show.getResult();
		switch(result){
		case OK:
			System.out.println("Ok");
			break;
		case Cancel:
			System.out.println("Cancel");
			break;
		case Yes:
			System.out.println("Yes");	
			break;
		case No:
			System.out.println("No");
			break;
		case Abort:
			System.out.println("Abort");
			break;
		case Retrey:
			System.out.println("Retrey");	
			break;
		case Ignore:
			System.out.println("Ignore");	
			break;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
