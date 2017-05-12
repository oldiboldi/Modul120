package View;

import java.util.Optional;

import Controller.MenuController;
import Controller.PhoneController;
import Controller.SettingsController;
import Model.Model;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SettingsView extends HBox {
	private final int BUTTON_WIDTH = 200;
	private final int BUTTON_HEIGHT = 50;
	private final GridPane ground = new GridPane();
	private final Label settingsLbl = new Label("Change Background Color");
	private final Button back = new Button("Back");
    private final Button colorBlue = new Button("Blau");
    private final Button colorRed = new Button("Rot");
    private final Button colorGrey = new Button("Grau");
    private final Button colorWhite = new Button("White");
    private final Button Off = new Button("Turn Off phone");
    private String bgColor;
    Model localModel;
    
	
    public SettingsView(final SettingsController settingsController, Model model) {
    	
    	localModel = new Model();
    	
    	ground.setStyle("-fx-background-color: "+localModel.getBackgroundColor()+";");
    	
    	colorBlue.setMinWidth(BUTTON_WIDTH);
    	colorBlue.setMinHeight(BUTTON_HEIGHT);
    	colorRed.setMinWidth(BUTTON_WIDTH);
    	colorRed.setMinHeight(BUTTON_HEIGHT);
    	colorGrey.setMinWidth(BUTTON_WIDTH);
    	colorGrey.setMinHeight(BUTTON_HEIGHT);
    	Off.setMinWidth(BUTTON_WIDTH);
    	Off.setMinHeight(BUTTON_HEIGHT);
    	colorWhite.setMinWidth(BUTTON_WIDTH);
    	colorWhite.setMinHeight(BUTTON_HEIGHT);
    	
    	ground.setHgap(10);
    	ground.setVgap(10);
    	ground.setMargin(colorBlue, new Insets(10, 10, 10, 10));
    	ground.setMargin(colorRed, new Insets(10, 10, 10, 10));
    	ground.setMargin(colorGrey, new Insets(10, 10, 10, 10));
    	ground.setMargin(colorWhite, new Insets(10, 10, 10, 10));
    	ground.setMargin(Off, new Insets(10, 10, 10, 10));
    	
    	ground.setConstraints(back, 1, 0);
    	ground.setConstraints(settingsLbl, 1, 2, 1, 1, HPos.CENTER, VPos.CENTER);
    	ground.setConstraints(colorBlue, 1, 3, 1, 1, HPos.CENTER, VPos.CENTER);
    	ground.setConstraints(colorRed, 1, 4, 1, 1, HPos.CENTER, VPos.CENTER);
    	ground.setConstraints(colorGrey, 1, 5, 1, 1, HPos.CENTER, VPos.CENTER);
    	ground.setConstraints(colorWhite, 1, 6, 1, 1, HPos.CENTER, VPos.CENTER);
    	ground.setConstraints(Off, 1, 7, 1, 1, HPos.CENTER, VPos.CENTER);
    	
    	ground.getChildren().add(back);
    	ground.getChildren().add(settingsLbl);
    	ground.getChildren().add(colorBlue);
    	ground.getChildren().add(colorRed);
    	ground.getChildren().add(colorGrey);
    	ground.getChildren().add(Off);
    	ground.getChildren().add(colorWhite);
    	
    	back.setOnAction(event -> {

            final Stage primaryStage = settingsController.getPrimaryStage();
            final MenuController controllerA = new MenuController(primaryStage, localModel);
            final Scene scene = new Scene(controllerA.getView());
            primaryStage.setScene(scene);
        });
    	
    	colorBlue.setOnAction(event -> {
    		ground.setStyle("-fx-background-color: cyan;");
    		
        });
    	
    	colorGrey.setOnAction(event -> {
    		ground.setStyle("-fx-background-color: grey;");
        });
    	
    	colorRed.setOnAction(event -> {
    		ground.setStyle("-fx-background-color: red;");
    		this.localModel.setBackgroundColor("red");
    	});
    	
    	colorWhite.setOnAction(event -> {
    		ground.setStyle("-fx-background-color: white;");
        });
    	Off.setOnAction(event -> {
    		System.exit(1);        
    	});
    	
        this.getChildren().addAll(ground); 
    }
    public Button goBack() {
        return back;
    }
}