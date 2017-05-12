package View;

import java.awt.TextField;
import java.util.Optional;

import Controller.CalculatorController;
import Controller.MenuController;
import Controller.PhoneController;
import Model.Model;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CalculatorView extends HBox {
    private final Button back = new Button("Back");
    private TextArea display;
	private String currentCalculateType;
	private float lastNumber;
	BorderPane backgroundPanel = new BorderPane();
    
    public CalculatorView(final CalculatorController calculatorController, Model model) {
    	
    	Model localModel = new Model();
    	
    	backgroundPanel.setStyle("-fx-background-color: "+localModel.getBackgroundColor()+";");
    	
    	Button key1, key2, key3, key4, key5, key6, key7, key8, key9, key0, keyPoint, keyDivide, keyPlus, keyMinus, keyMultiply, keyClear, keySquare, keyPos, keyEquals;
		
		display = new TextArea();
		display.setEditable(false);
		display.setMaxWidth(500);
		
		
		key1 = new Button("1");
        key2 = new Button("2");
        key3 = new Button("3");
        key4 = new Button("4");
        key5 = new Button("5");
        key6 = new Button("6");
        key7 = new Button("7");
        key8 = new Button("8");
        key9 = new Button("9");
        key0 = new Button("0");
        keyPoint = new Button(".");
        keyDivide = new Button("/");
        keyPlus = new Button("+");
        keyMinus = new Button("-"); 
        keyMultiply = new Button("*");
        keyClear = new Button("C");
        keySquare = new Button("√");
        keyPos = new Button("+/-");
        keyEquals = new Button("=");
        
        key1.setMinSize(80, 50);
        key2.setMinSize(80, 50);
        key3.setMinSize(80, 50);
        key4.setMinSize(80, 50);
        key5.setMinSize(80, 50);
        key6.setMinSize(80, 50);
        key7.setMinSize(80, 50);
        key8.setMinSize(80, 50);
        key9.setMinSize(80, 50);
        keyPoint.setMinSize(80, 50);
        keyPlus.setMinSize(80, 50);
        keyMinus.setMinSize(80, 50);
        keyMultiply.setMinSize(80, 50);
        keyDivide.setMinSize(80, 50);
        keyClear.setMinSize(80, 50);
        keySquare.setMinSize(80, 50);
        keyPos.setMinSize(80, 50);
        keyEquals.setMinSize(80, 50);
        key0.setMinSize(80, 50);
        
        key1.setOnAction((ActionEvent e) -> output("1"));
        key2.setOnAction((ActionEvent e) -> output("2"));
        key3.setOnAction((ActionEvent e) -> output("3"));
        key4.setOnAction((ActionEvent e) -> output("4"));
        key5.setOnAction((ActionEvent e) -> output("5"));
        key6.setOnAction((ActionEvent e) -> output("6"));
        key7.setOnAction((ActionEvent e) -> output("7"));
        key8.setOnAction((ActionEvent e) -> output("8"));
        key9.setOnAction((ActionEvent e) -> output("9"));
        key0.setOnAction((ActionEvent e) -> output("0"));
        keyPoint.setOnAction((ActionEvent e) -> output("."));
        keyClear.setOnAction((ActionEvent e) -> setClear());
        keyPlus.setOnAction((ActionEvent e) -> setType("Plus"));
        keyMinus.setOnAction((ActionEvent e) -> setType("Minus"));
        keyMultiply.setOnAction((ActionEvent e) -> setType("Multiply"));
        keyDivide.setOnAction((ActionEvent e) -> setType("Divide"));
        keyEquals.setOnAction((ActionEvent e) -> calculate());
        keyPos.setOnAction((ActionEvent e) -> setNeg());
        keySquare.setOnAction((ActionEvent e) -> setSquare());
        
        GridPane buttons = new GridPane();
        buttons.setPadding(new Insets(0,10,0,10));
        buttons.setVgap(20);
        buttons.setHgap(15);
        buttons.getChildren().addAll(key7, key8, key9, keyPlus, keyClear, key4, key5, key6, keyMinus, keySquare, key1, key2, key3, keyMultiply, keyPos, key0, keyPoint, keyDivide, keyEquals);
        
        buttons.setConstraints(key7, 0, 0);
		buttons.setConstraints(key8, 1, 0);
		buttons.setConstraints(key9, 2, 0);
		buttons.setConstraints(keyPlus, 3, 0);
		buttons.setConstraints(keyClear, 4, 0);
		
		buttons.setConstraints(key4, 0, 1);
		buttons.setConstraints(key5, 1, 1);
		buttons.setConstraints(key6, 2, 1);
		buttons.setConstraints(keyMinus, 3, 1);
		buttons.setConstraints(keySquare, 4, 1);
		
		buttons.setConstraints(key1, 0, 2);
		buttons.setConstraints(key2, 1, 2);
		buttons.setConstraints(key3, 2, 2);
		buttons.setConstraints(keyMultiply, 3, 2);
		buttons.setConstraints(keyPos, 4, 2);
		
		buttons.setConstraints(key0, 0, 3);
		buttons.setConstraints(keyPoint, 2, 3);
		buttons.setConstraints(keyDivide, 3, 3);
		buttons.setConstraints(keyEquals, 4, 3);
    	
    	back.setOnAction(event -> {

            final Stage primaryStage = calculatorController.getPrimaryStage();
            final MenuController controllerA = new MenuController(primaryStage, model);
            final Scene scene = new Scene(controllerA.getView());
            primaryStage.setScene(scene);
        });
    	
		VBox displayText = new VBox();
		displayText.getChildren().add(display);
    	
		backgroundPanel.setTop(back);
		backgroundPanel.setCenter(displayText);
		backgroundPanel.setBottom(buttons);
		backgroundPanel.setPadding(new Insets(10, 10, 10, 10));
    	
        this.getChildren().addAll(backgroundPanel);

        }
    public Button goBack() {
        return back;
    }
    
	private void setClear() {
		display.setText("");
		currentCalculateType = "none";
		lastNumber = 0;
	}
	
	private void setType(String type){
		currentCalculateType = type;
		lastNumber = Float.parseFloat(display.getText());
		display.setText("");
	}
	
	private void setSquare(){
		float currentNumber = Float.parseFloat(display.getText());
		currentNumber = (float) Math.sqrt(currentNumber);
		display.setText(Float.toString(currentNumber));
	}
	
	private void setNeg(){
		float currentNumber = Float.parseFloat(display.getText());
		if(currentNumber > 0){
			display.setText("-" + currentNumber);
		} else {
			display.setText(Float.toString(currentNumber * -1));
		}
	}
	
	private void calculate(){
		float currentNumber = Float.parseFloat(display.getText());
		
		switch(currentCalculateType){
		case "Plus":
			display.setText(Float.toString(currentNumber + lastNumber));
			break;
		case "Minus":
			display.setText(Float.toString(lastNumber - currentNumber));
			
			break;
		case "Multiply":
			display.setText(Float.toString(lastNumber * currentNumber));
			
			break;
		case "Divide":
			display.setText(Float.toString(lastNumber / currentNumber));
			
			break;
		}
	}
    
	private void output(String value){
        display.setText(display.getText() + value);
    }
}