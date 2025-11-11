package com.example.smartloginsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class TeacherDashboardController {
    public void showStudents(ActionEvent actionEvent) {
    }

    public void showPending(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AllSubmissionController.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Teacher Dashboard");
        stage.show();
    }

    public void showAnalytics(ActionEvent actionEvent) {
    }

    public void handleLogout(ActionEvent actionEvent) {
    }

    public void showSupervisorSlots(ActionEvent actionEvent) {
    }

    public void showPostIdea(ActionEvent actionEvent) {
    }

    public void showSettings(ActionEvent actionEvent) {

    }
}
