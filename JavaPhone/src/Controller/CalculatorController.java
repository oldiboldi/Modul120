package Controller;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Model;
import View.CalculatorView;
import View.MenuView;
import View.PhoneView;
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

public class CalculatorController {
    private final Stage primaryStage;
    Model model;
    private final CalculatorView view = new CalculatorView(this, model);

    public CalculatorController(final Stage primaryStage, Model model) {
        this.primaryStage = primaryStage;
        this.model = model;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public CalculatorView getView() {
        return view;
    }
}