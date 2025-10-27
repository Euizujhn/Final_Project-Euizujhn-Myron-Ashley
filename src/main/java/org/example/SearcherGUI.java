package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearcherGUI extends Application {
    RecipeFormat format = new RecipeFormat();
    private Stage Mainstage;

    @Override
    public void start(Stage stage) throws Exception {
        VBox parent = new VBox();
        parent.getChildren().add(new Label("The Meal Database"));
        HBox urlArea = new HBox(new Label("Enter Meal to Received Recipe"));
        TextField textField = new TextField();
        urlArea.getChildren().add(textField);
        parent.getChildren().add(urlArea);
        Button button = new Button("Find Recipe");
        button.setOnAction(event -> {
            String input = textField.getText();
            VBox root = new VBox();
            root.getChildren().add(new Label(format.IngredientsGUI(input)));
            Button button2 = new Button("Go Back");
            button2.setOnAction(event2 -> { stage.setScene(parent.getScene()); stage.show();});
            root.getChildren().add(button2);
            Scene scene = new Scene(root, 400, 300);
            stage.setScene(scene);
            stage.show();
        });

        StackPane root = new StackPane(button);
        parent.getChildren().add(button);
        stage.setScene(new Scene(parent));
        stage.show();
        Mainstage = stage;


    }
}
