package com.example.smartloginsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class popupcontroller {

    @FXML
    private Label studentLabel, titleLabel, teacherLabel, statusLabel;

    public void setSubmissionDetails(String student, String title, String teacher, String status) {
        studentLabel.setText("Student: " + student);
        titleLabel.setText("Title: " + title);
        teacherLabel.setText(teacher);
        statusLabel.setText("Status: " + status);
    }

    public void closeWindow() {
        Stage stage = (Stage) studentLabel.getScene().getWindow();
        stage.close();
    }
}
