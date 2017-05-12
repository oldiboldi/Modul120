package application;

import javafx.scene.paint.Color;

import Controller.MenuController;
import Model.Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(final String[] args) {
        launch();
    }

    @Override
    public void init() {}

    @Override
    public void start(final Stage primaryStage) throws Exception {
    	Model model = new Model();
    	model.setBackgroundColor("cyan");
        final Scene scene = new Scene(new MenuController(primaryStage, model).getView());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}