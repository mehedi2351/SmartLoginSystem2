package com.example.smartloginsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProjectSubmittedController {
    public void handleBrowseFile(ActionEvent actionEvent) {
    }

    public void handleSubmit(ActionEvent actionEvent) {
    }

    public void gotodashboard(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Find Supervisor");
        if (stage.isMaximized()) {
            stage.setMaximized(false); // একটু ছোট করুন
            stage.setMaximized(true);  // আবার বড় করুন (এতে কন্টেন্ট সেন্টারে চলে আসবে)
        } else {
            stage.setMaximized(true);
        }
        stage.show();

    }
}
