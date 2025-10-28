package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SearcherGUI extends Application {
    ArrayList<String> Favorite = new ArrayList();
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
            root.getChildren().add(new Label(RecipeFormat.IngredientsGUI(input)));
            root.getChildren().add(new Label("Would you like to add to favorites?"));
            Button button2 = new Button("Yes");
            button2.setOnAction(event2 -> {Favorite.add(RecipeFormat.IngredientsGUI(input)); stage.setScene(parent.getScene()); stage.show();});
            root.getChildren().add(button2);
            Button button3 = new Button("No");
            button3.setOnAction(event3 -> {stage.setScene(parent.getScene()); stage.show();});
            root.getChildren().add(button3);
            Scene scene = new Scene(root, 400, 300);
            stage.setScene(scene);
            stage.show();
        });

        Button button1 = new Button("Check Favorites");
        button1.setOnAction(event2 -> {
            VBox root2 = new VBox();

            if (Favorite.isEmpty()){
                root2.getChildren().add(new Label("Nothing has been added"));
                Button button3 = new Button("Go Back");
                button3.setOnAction(event3 -> {stage.setScene(parent.getScene()); stage.show();});
                root2.getChildren().add(button3);
                Scene scene = new Scene(root2, 400, 300);
                stage.setScene(scene);
                stage.show();
            } else {
               for (int i = 0; i <= 5; i++) {
                   root2.getChildren().add(new Label(Favorite.get(i)));

                   Button button3 = new Button("Go Back");
                   button3.setOnAction(event3 -> {
                       stage.setScene(parent.getScene());
                       stage.show();
                   });
                   root2.getChildren().add(button3);
                   Scene scene = new Scene(root2, 600, 600);
                   stage.setScene(scene);
                   stage.show();
               }
            }
        });


        StackPane root = new StackPane(button);
        parent.getChildren().add(button);
        parent.getChildren().add(button1);
        stage.setScene(new Scene(parent));
        stage.show();
        Mainstage = stage;


    }
}

