package com.github.szypr.inu.messagebox;

import java.io.InputStream;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Show {
	
	private static Stage stage= new Stage();
	private static Button btnYes = new Button("Tak");
	private static Button btnNo = new Button("Nie");
	private static Button btnCancel = new Button("Anuluj");
	private static Button btnOk = new Button("OK");
	private static Button btnAbort = new Button("Przerwij");
	private static Button btnRetrey = new Button("Wznów");
	private static Button btnIgnore = new Button("Ignoruj");
	private static Label label= new Label();
	private static HBox hBox1 = new HBox();
	private static HBox hBox2 = new HBox();
	private static VBox vBox = new VBox();
	private static Scene scene= new Scene(vBox, 500, 150);
	private static MessageBoxResult result;
	
	
	public enum MessageBoxIcon {Information("StatusInformation_64x.png"), Warning("StatusWarning_64x.png"), Alert("StatusAlert_64x.png"), CriticalError("StatusCriticalError_64x.png");
		private  String iconName;
		private  MessageBoxIcon(String iconName) {this.iconName = iconName;}
		
		public String getMessageBoxIconName() {
			return iconName;
		}};

	public enum MessageBoxButton {AbortRetreyIgnore, OK, OkCancel, YesNo, YesNoCancel}
	
	public enum MessageBoxResult {Abort, Retrey, Ignore, OK, Cancel, Yes, No;
		
		public void result() {
			
			if(this == OK) {
				btnOk.setDefaultButton(true);
				btnOk.setOnAction(e -> {stage.close(); result = OK;});
			}
			else if(this==Cancel) {
				btnCancel.setCancelButton(true);
				btnCancel.setOnAction(e -> {stage.close(); result = Cancel;});
			}
			else if(this==Yes) {
				btnYes.setDefaultButton(true);
				btnYes.setOnAction(e -> {stage.close(); result = Yes;});
			}
			else if(this==No) {
				btnNo.setCancelButton(true);
				btnNo.setOnAction(e -> {stage.close(); result = No;});
			}
			else if(this==Abort) {
				btnAbort.setCancelButton(true);
				btnAbort.setOnAction(e -> {stage.close(); result = Abort;});
			}
			else if(this==Retrey) {
				btnRetrey.setDefaultButton(true);
				btnRetrey.setOnAction(e -> {stage.close(); result = Retrey;});
			}
			else if(this==Ignore) {
				
				btnIgnore.setOnAction(e -> {stage.close(); result = Ignore;});
				
			}
		}
	}
	
	
	// METODA SHOW
	public static void show(String msg, String title, MessageBoxIcon ico, MessageBoxButton btn) {
	
		setHBox1(msg, ico);
		setHBox2(btn);
		setVBox();
		setPosition();
		
		stage.setScene(scene);
		stage.setTitle(title);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
		getResult();
		
		
	}
	
	//POZOSTA�E METODY
	
	public static void setHBox1(String msg, MessageBoxIcon ico) {
		
		label.setText(msg);
		label.setWrapText(true);
		label.setFont(Font.font("Arial", FontWeight.NORMAL, 14)); 
		label.setFont(Font.font(12));
	

		
		InputStream in = ClassLoader.getSystemResourceAsStream(ico.getMessageBoxIconName());
		if (in==null) {
			Label imageView= new Label("tutaj powinien by� obrazek");
			hBox1.getChildren().addAll(imageView, label);	
		}
		else {
			Image icon = new Image(in);
			ImageView imageView = new ImageView(icon);
			hBox1.getChildren().addAll(imageView, label);	
		}
		
		hBox1.setSpacing(30);
	}
	
	
	public static void setHBox2(MessageBoxButton btn) {
		
		switch(btn) {
		
		case AbortRetreyIgnore:
			hBox2.getChildren().addAll(btnAbort, btnRetrey,btnIgnore);
			MessageBoxResult.Abort.result();
			MessageBoxResult.Retrey.result();
			MessageBoxResult.Ignore.result();
			break;
		case OK:
			hBox2.getChildren().addAll(btnOk);
			MessageBoxResult.OK.result();
			
			break;
		case OkCancel:
			hBox2.getChildren().addAll(btnOk, btnCancel);
			MessageBoxResult.OK.result();
			MessageBoxResult.Cancel.result();
			
			break;
		case YesNo:
			hBox2.getChildren().addAll(btnYes, btnNo);
			MessageBoxResult.Yes.result();
			MessageBoxResult.No.result();
			
			break;
		case YesNoCancel:
			hBox2.getChildren().addAll(btnYes, btnNo, btnCancel);
			MessageBoxResult.Yes.result();
			MessageBoxResult.No.result();
			MessageBoxResult.Cancel.result();
			break;
			}	
		
		
		setBtn();
		
		hBox2.setSpacing(10);
		
		
	}
	
	public static void setVBox() {
		vBox.getChildren().addAll(hBox1, hBox2);
		vBox.setSpacing(20);
		vBox.setPadding(new Insets(10));
		
		
	}
	
	public static void setPosition() {
		
		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.TOP_CENTER);
		vBox.setAlignment(Pos.CENTER);
	}
	
	public static void setBtn() {
		
		InputStream ok = ClassLoader.getSystemResourceAsStream("StatusOK_32x.png");
		Image iconOk = new Image(ok);
		ImageView imageOk = new ImageView(iconOk);
		InputStream no = ClassLoader.getSystemResourceAsStream("StatusNo_32xLG.png");
		Image iconNo = new Image(no);
		ImageView imageNo = new ImageView(iconNo);
		
		
		btnYes.setGraphic(imageOk);
		btnYes.setGraphicTextGap(10);
		btnYes.setPrefSize(150, 40);
		btnYes.setFont( Font.font(label.getFont().getName(), FontWeight.BOLD, label.getFont().getSize()));
		
		
		btnNo.setGraphic(imageNo);
		btnNo.setGraphicTextGap(10);
		btnNo.setPrefSize(150, 40);
		btnNo.setFont( Font.font(label.getFont().getName(), FontWeight.BOLD, label.getFont().getSize()));
		
		btnOk.setGraphic(imageOk);
		btnOk.setGraphicTextGap(10);
		btnOk.setPrefSize(150, 40);
		btnOk.setFont( Font.font(label.getFont().getName(), FontWeight.BOLD, label.getFont().getSize()));
		
		btnCancel.setGraphic(imageNo);
		btnCancel.setGraphicTextGap(10);
		btnCancel.setPrefSize(150, 40);
		btnCancel.setFont( Font.font(label.getFont().getName(), FontWeight.BOLD, label.getFont().getSize()));
		
		btnAbort.setPrefSize(150, 40);
		btnAbort.setFont( Font.font(label.getFont().getName(), FontWeight.BOLD, label.getFont().getSize()));
		btnRetrey.setPrefSize(150, 40);
		btnRetrey.setFont( Font.font(label.getFont().getName(), FontWeight.BOLD, label.getFont().getSize()));
		btnIgnore.setPrefSize(150, 40);
		btnIgnore.setFont( Font.font(label.getFont().getName(), FontWeight.BOLD, label.getFont().getSize()));
	}
	
	public static MessageBoxResult getResult() {
		return result;
	}
		
	
	

}
