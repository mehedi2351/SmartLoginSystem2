package com.example.smartloginsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root,1000,800);
        stage.setScene(scene);

        stage.setTitle("supervisor management system ");


        stage.setResizable(true);
        stage.setWidth(1400);
        stage.setHeight(800);
        stage.setMinHeight(700);
        stage.setMinWidth(1200);
      //  stage.setMaximized(true);
        if (stage.isMaximized()) {
            stage.setMaximized(false); // একটু ছোট করুন
            stage.setMaximized(true);  // আবার বড় করুন (এতে কন্টেন্ট সেন্টারে চলে আসবে)
        } else {
            stage.setMaximized(true);
        }
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
