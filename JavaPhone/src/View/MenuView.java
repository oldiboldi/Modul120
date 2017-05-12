package View;

import Controller.MenuController;
import Model.Model;
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

public class MenuView extends HBox {
    private final Button button = new Button("ButtonA");
    private final GridPane display = new GridPane();
    private final int ICONSIZE = 200;
    private Button phone;
    private Button contacts;
    private Button settings;
    private Button calculator;
    Model localModel = new Model();
    
    
    public MenuView(final MenuController menuController, Model model) {
    	localModel = model;
    	String bgColor = localModel.getBackgroundColor();
    	
    	display.setStyle("-fx-background-color: "+bgColor+";");
    	
        display.setHgap(10);
        display.setVgap(10);
        ImageView phoneIcon = new ImageView(new Image("File:img/Phone_Icon.png"));
        ImageView contactsIcon = new ImageView(new Image("File:img/Contacts_Icon.png"));
        ImageView settingsIcon = new ImageView(new Image("File:img/Settings.png"));
        ImageView calculatorIcon = new ImageView(new Image("File:img/Calculater.png"));
        ImageView empty = new ImageView(new Image("File:img/idk.png"));
        
        phoneIcon.setFitHeight(ICONSIZE);
        phoneIcon.setFitWidth(ICONSIZE);
        contactsIcon.setFitHeight(ICONSIZE);
        contactsIcon.setFitWidth(ICONSIZE);
        settingsIcon.setFitHeight(ICONSIZE);
        settingsIcon.setFitWidth(ICONSIZE);
        calculatorIcon.setFitHeight(ICONSIZE);
        calculatorIcon.setFitWidth(ICONSIZE);
        empty.setFitHeight(ICONSIZE);
        empty.setFitWidth(ICONSIZE);
        
        phone = new Button("", phoneIcon);
        contacts = new Button("", contactsIcon);
        settings = new Button("", settingsIcon);
        calculator = new Button("", calculatorIcon);
        
        phone.setOnAction(menuController);
        contacts.setOnAction(menuController);
        settings.setOnAction(menuController);
        calculator.setOnAction(menuController);
        
        phone.setBackground(Background.EMPTY);
        contacts.setBackground(Background.EMPTY);
        settings.setBackground(Background.EMPTY);
        calculator.setBackground(Background.EMPTY);
        
        display.setPrefSize(this.getWidth(), this.getHeight()); // Default width and height
        display.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        
        display.setConstraints(phone, 1, 0);
        display.setConstraints(contacts, 2, 0);
        display.setConstraints(settings, 3, 0);
        display.setConstraints(calculator, 1, 1);
        display.setConstraints(empty, 2, 1);
        display.setConstraints(empty, 3, 1);
        display.setConstraints(empty, 1, 2);
        display.setConstraints(empty, 2, 2);
        display.setConstraints(empty, 3, 2);
        
        display.getChildren().add(0, phone);
        display.getChildren().add(1, contacts);
        display.getChildren().add(2, settings);
        display.getChildren().add(3, calculator);
        display.getChildren().add(empty);
        
        this.getChildren().add(display);
    }

    public Button getPhone() {
        return phone;
    }
    public Button getContacts() {
        return contacts;
    }
    public Button getSettings() {
        return settings;
    }
    public Button getCalculator() {
        return calculator;
    }
}