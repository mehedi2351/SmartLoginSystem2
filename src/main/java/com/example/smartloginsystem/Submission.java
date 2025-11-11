package com.example.smartloginsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Submission {

    private String studentName;
    private String title;
    private String date;
    private String status;
    private Button actionBtn; // Button object (not String)

    // Constructor
    public Submission(String studentName, String title, String date, String status) {
        this.studentName = studentName;
        this.title = title;
        this.date = date;
        this.status = status;

        // Initialize button
        actionBtn = new Button("👁 View");
        actionBtn.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-background-radius: 5;");
        actionBtn.setOnAction(e -> openViewPopup());
    }

    // Method to open popup
    private void openViewPopup() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewSubmission.fxml"));
            Parent root = loader.load();

            // Controller access
            ViewSubmissionController controller = loader.getController();
            controller.setSubmissionDetails(studentName, title, date, status);

            // Popup window setup
            Stage popupStage = new Stage();
            popupStage.setTitle("View Submission");
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Getters
    public String getStudentName() { return studentName; }
    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
    public Button getActionBtn() { return actionBtn; } // Important for TableView binding

    // Optional Setters (if needed later)
    public void setStatus(String status) { this.status = status; }
}
