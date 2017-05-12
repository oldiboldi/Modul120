package View;

import java.awt.TextField;

import Controller.ContactsController;
import Controller.MenuController;
import Controller.PhoneController;
import Model.Model;
import Model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
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
import javafx.stage.Stage;

public class ContactsView extends HBox {
	private final GridPane ground = new GridPane();
    private final Button back = new Button("Back");
    private final Label contactListLbl = new Label("Existing Contacts:");
    private final TableView contactList = new TableView();
    private final Label createNewContactLbl = new Label();
    private final Button addNumber = new Button("Create");
    private final Label newContactNumberLbl = new Label("New Contact Number:");
    private final TextArea newContactNumber = new TextArea();
    private final Label newContactNameLbl = new Label("New Contact Name:");
    private final TextArea newContactName = new TextArea();
    
    final ObservableList<Person> data = FXCollections.observableArrayList(
    	    new Person("Jacob", "Smith", "0764209119"),
    	    new Person("Isabella", "Johnson", "0764209119"),
    	    new Person("Ethan", "Williams", "0764209119"),
    	    new Person("Emma", "Jones", "0764209119"),
    	    new Person("Michael", "Brown", "0764209119")
    	);
    
    public ContactsView(final ContactsController contactsController, Model model) {
    	
    	Model localModel = new Model();
    	
    	ground.setStyle("-fx-background-color: "+localModel.getBackgroundColor()+";");
    	
    	contactList.setEditable(true);
    	 
    	TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
 
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));
 
        TableColumn numberCol = new TableColumn("Telephone Number");
        numberCol.setMinWidth(200);
        numberCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("telephoneNumber"));
            	
        newContactNumber.setMaxHeight(5);
        newContactNumber.setMaxWidth(250);
        newContactName.setMaxHeight(5);
        newContactName.setMaxWidth(250);
        
        firstNameCol.setCellValueFactory(
    	    new PropertyValueFactory<Person,String>("firstName")
    	);
    	lastNameCol.setCellValueFactory(
    	    new PropertyValueFactory<Person,String>("lastName")
    	);
    	numberCol.setCellValueFactory(
    	    new PropertyValueFactory<Person,String>("telephoneNumber")
    	);
    	
        contactList.getColumns().addAll(firstNameCol, lastNameCol, numberCol);
        contactList.setItems(data);
        
    	back.setOnAction(event -> {

            final Stage primaryStage = contactsController.getPrimaryStage();
            final MenuController controllerA = new MenuController(primaryStage, model);
            final Scene scene = new Scene(controllerA.getView());
            primaryStage.setScene(scene);
        });
    	
    	addNumber.setAlignment(Pos.CENTER);
    	
    	ground.setConstraints(back, 1, 0);
    	ground.setConstraints(contactListLbl, 1, 1);
    	ground.setConstraints(contactList, 1, 2);
    	ground.setConstraints(createNewContactLbl, 1, 3);
    	ground.setConstraints(newContactNameLbl, 1, 4, 1, 1, HPos.CENTER, VPos.CENTER);
    	ground.setConstraints(newContactName, 1, 5, 1, 1, HPos.CENTER, VPos.CENTER);
    	ground.setConstraints(newContactNumberLbl, 1, 6, 1, 1, HPos.CENTER, VPos.CENTER);
    	ground.setConstraints(newContactNumber, 1, 7, 1, 1, HPos.CENTER, VPos.CENTER);
    	ground.setConstraints(addNumber, 1, 8, 1, 1, HPos.CENTER, VPos.CENTER);

    	ground.getChildren().add(back);
    	ground.getChildren().add(contactListLbl);
    	ground.getChildren().add(contactList);
    	ground.getChildren().add(createNewContactLbl);
    	ground.getChildren().add(newContactNameLbl);
    	ground.getChildren().add(newContactName);
    	ground.getChildren().add(newContactNumberLbl);
    	ground.getChildren().add(newContactNumber);
    	ground.getChildren().add(addNumber);
    	
        this.getChildren().addAll(ground);
        
    }
    public Button goBack() {
        return back;
    }
}