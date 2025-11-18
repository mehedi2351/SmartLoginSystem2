package com.example.smartloginsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class AllSubmissionController {

    @FXML
    private TableView<Submission> submissionTable;
    @FXML
    private TableColumn<Submission, String> colStudent;
    @FXML
    private TableColumn<Submission, String> titleCol;
    @FXML
    private TableColumn<Submission, String> dateCol;
    @FXML
    private TableColumn<Submission, String> statusCol;
    @FXML
    private TableColumn<Submission, String> actionCol;

    @FXML
    public void initialize() {
        System.out.println("Initialize method called (Teacher Panel)");

        // Column setup
        colStudent.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        actionCol.setCellValueFactory(new PropertyValueFactory<>("actionBtn"));

        // Load sample data
        ObservableList<Submission> submissions = loadSampleData();
        submissionTable.setItems(submissions);

      //  System.out.println("Loaded submissions: " + submissions.size());
    }

    private ObservableList<Submission> loadSampleData() {
        ObservableList<Submission> submissions = FXCollections.observableArrayList();

        submissions.add(new Submission("Mehedi Hasan", "Smart Thesis Manager",
                "2025-11-05", "Pending"));
        submissions.add(new Submission("Rafi Ahmed",
                "IoT Health Monitoring", "2025-11-04", "Approved"));
        submissions.add(new Submission("Sadia Khan", "AI Chatbot System", "2025-11-03", "Rejected"));
        submissions.add(new Submission("Nusrat Jahan", "E-Learning Platform", "2025-11-02", "Pending"));

        return submissions;
    }

    public void handleViewDetails(ActionEvent event) throws IOException {
        // Open popup window to show details
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewSubmission.fxml"));
        Parent root = loader.load();

        Stage popupStage = new Stage();
        popupStage.setScene(new Scene(root));
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("View Submission Details");
        popupStage.show();
    }

    public void handleBackToDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherDashboard.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Teacher Dashboard");
        stage.show();
    }

    public void handleRefresh(ActionEvent actionEvent) {
    }

    public void handleExport(ActionEvent actionEvent) {
    }

    public void goToDashboard(ActionEvent actionEvent) {
    }
}
