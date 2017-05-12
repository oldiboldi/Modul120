package View;

import java.awt.TextField;

import Controller.MenuController;
import Controller.PhoneController;
import Model.Model;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PhoneView extends HBox {
	private final GridPane numbers = new GridPane();
	private final Button back = new Button("Back");
	private final GridPane ground = new GridPane();
	private Label telephoneNumberLbl = new Label("Telephone number:");
	private final TextArea telephoneNumber = new TextArea();
	private Button callButton;
	
    public PhoneView(final PhoneController phoneController, Model model) {
    	
    	Model localModel = new Model();
    	
    	ground.setStyle("-fx-background-color: "+localModel.getBackgroundColor()+";");
    	
    	Button key1, key2, key3, key4, key5, key6, key7, key8, key9, key0;
		
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
        
        key0.setMinSize(240, 50);
        key1.setMinSize(80, 50);
        key2.setMinSize(80, 50);
        key3.setMinSize(80, 50);
        key4.setMinSize(80, 50);
        key5.setMinSize(80, 50);
        key6.setMinSize(80, 50);
        key7.setMinSize(80, 50);
        key8.setMinSize(80, 50);
        key9.setMinSize(80, 50);
        
        key1.setOnAction(event -> { 
            telephoneNumber.setText(telephoneNumber.getText()+"1");
        });
        
        key2.setOnAction(event -> { 
            telephoneNumber.setText(telephoneNumber.getText()+"2");
        });
        
        key3.setOnAction(event -> { 
            telephoneNumber.setText(telephoneNumber.getText()+"3");
        });
        
        key4.setOnAction(event -> { 
            telephoneNumber.setText(telephoneNumber.getText()+"4");
        });
        
        key5.setOnAction(event -> { 
            telephoneNumber.setText(telephoneNumber.getText()+"5");
        });
        
        key6.setOnAction(event -> { 
            telephoneNumber.setText(telephoneNumber.getText()+"6");
        });
        
        key7.setOnAction(event -> { 
            telephoneNumber.setText(telephoneNumber.getText()+"7");
        });
        
        key8.setOnAction(event -> { 
            telephoneNumber.setText(telephoneNumber.getText()+"8");
        });
        
        key9.setOnAction(event -> { 
            telephoneNumber.setText(telephoneNumber.getText()+"9");
        });
        
        key0.setOnAction(event -> { 
            telephoneNumber.setText(telephoneNumber.getText()+"0");
        });
        

        
        
        numbers.setConstraints(key0, 0, 0, 3, 1, HPos.CENTER, VPos.CENTER);
        numbers.setConstraints(key1, 0, 1);
        numbers.setConstraints(key2, 1, 1);
        numbers.setConstraints(key3, 2, 1);
        numbers.setConstraints(key4, 0, 2);
        numbers.setConstraints(key5, 1, 2);
        numbers.setConstraints(key6, 2, 2);
        numbers.setConstraints(key7, 0, 3);
        numbers.setConstraints(key8, 1, 3);
        numbers.setConstraints(key9, 2, 3);
        
        numbers.getChildren().add(key0);
        numbers.getChildren().add(key1);
        numbers.getChildren().add(key2);
        numbers.getChildren().add(key3);
        numbers.getChildren().add(key4);
        numbers.getChildren().add(key5);
        numbers.getChildren().add(key6);
        numbers.getChildren().add(key7);
        numbers.getChildren().add(key8);
        numbers.getChildren().add(key9);
    	
        ImageView callButtonImg = new ImageView(new Image("File:img/CallButton.png"));
        callButtonImg.setFitHeight(50);
        callButtonImg.setFitWidth(50);
        
        telephoneNumber.setMaxHeight(5);
        telephoneNumber.setMaxWidth(250);
        
    	callButton = new Button("", callButtonImg);
    	callButton.setBackground(Background.EMPTY);
    	callButton.setAlignment(Pos.CENTER);
    	
        callButton.setOnAction(event -> { 
            telephoneNumber.setText("");
        });
    	
    	ground.setHgap(10);
        ground.setVgap(10);
    	
    	back.setOnAction(event -> { 

            final Stage primaryStage = phoneController.getPrimaryStage();
            final MenuController controllerA = new MenuController(primaryStage, model);
            final Scene scene = new Scene(controllerA.getView());
            primaryStage.setScene(scene);
        });
    	
    	ground.setConstraints(back, 1, 0);
    	ground.setConstraints(numbers, 1, 1, 1, 1, HPos.CENTER, VPos.CENTER);
    	ground.setConstraints(telephoneNumberLbl, 1, 2, 1, 1, HPos.CENTER, VPos.CENTER);
    	ground.setConstraints(telephoneNumber, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER);
    	ground.setConstraints(callButton, 1, 4, 1, 1, HPos.CENTER, VPos.CENTER);
    	
    	ground.getChildren().add(back);
    	ground.getChildren().add(numbers);
    	ground.getChildren().add(telephoneNumberLbl);
    	ground.getChildren().add(telephoneNumber);
    	ground.getChildren().add(callButton);
    	
        this.getChildren().addAll(ground);
}
    
    public Button goBack() {
        return back;
    }
}