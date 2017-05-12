package Controller;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Model;
import View.MenuView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuController implements EventHandler {
    private final Stage primaryStage;
    Model model = new Model();
    private final MenuView view = new MenuView(this, model);

    public MenuController(final Stage primaryStage, Model model) {
        this.primaryStage = primaryStage;
        this.model = model;
    }

    @Override
    public void handle(final Event event) {
        final Object source = event.getSource();

        if (source.equals(view.getPhone())) {
        	
        	final PhoneController phoneController = new PhoneController(primaryStage, model);
        	final Scene scene = new Scene(phoneController.getView());
        	primaryStage.setScene(scene);
        	
        }
        if (source.equals(view.getContacts())) {
        	
        	final ContactsController contactsController = new ContactsController(primaryStage, model);
        	final Scene scene = new Scene(contactsController.getView());
        	primaryStage.setScene(scene);
        	
        }
        if (source.equals(view.getSettings())) {
        	
        	final SettingsController settingsController = new SettingsController(primaryStage, model);
        	final Scene scene = new Scene(settingsController.getView());
        	primaryStage.setScene(scene);
        	
        }
        if (source.equals(view.getCalculator())) {
        	
        	final CalculatorController calculatorController = new CalculatorController(primaryStage, model);
        	final Scene scene = new Scene(calculatorController.getView());
        	primaryStage.setScene(scene);        
        	
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public MenuView getView() {
        return view;
    }
}