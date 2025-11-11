package com.example.smartloginsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ViewSubmissionController {

    @FXML
    private Label studentLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private TextArea descArea;

    private Submission submission;


    public void setSubmissionDetails(String student, String title, String date, String status) {
        studentLabel.setText(student);
        titleLabel.setText(title);
        dateLabel.setText(date);
        statusLabel.setText(status);

        // Example description (later will load from file)
        descArea.setText("This project focuses on managing thesis and project submissions in a smart automated way using file-based or database storage.");
    }

    public void handleApprove(ActionEvent event) {
        statusLabel.setText("Approved ✅");
        statusLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Project Approved Successfully!", ButtonType.OK);
        alert.showAndWait();
    }

    public void handleReject(ActionEvent event) {
        statusLabel.setText("Rejected ❌");
        statusLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        //massge use kra jbe je ba warning type er
        Alert alert = new Alert(Alert.AlertType.WARNING, "Project Rejected.", ButtonType.OK);
        alert.showAndWait();
    }

    public void handleClose(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
