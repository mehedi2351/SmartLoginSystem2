package com.example.smartloginsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TeacherDashboardController implements Initializable {

    // FXML Elements binding
    @FXML private Label teacherName;
    @FXML private Label teacherRole;
    @FXML private ImageView avatarView;

    // KPI Cards
    @FXML private Label supervisedCount;
    @FXML private Label pendingCount;
    @FXML private Label alertCount;

    // Charts
    @FXML private PieChart projectPie;
    @FXML private LineChart<String, Number> studentProgressChart;

    // Sidebar Buttons (For styling)
    @FXML private Button btnDashboard;
    @FXML private Button btnPending;
    @FXML private Button btnSlots;
    @FXML private Button btnPostIdea;
    @FXML private Button btnSettings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 1. Load Dummy Data for Dashboard
        loadDashboardData();

        // 2. Set "Dashboard" button as active by default
        setActiveButton(btnDashboard);
    }

    private void loadDashboardData() {
        // Set Stats
        supervisedCount.setText("12");
        pendingCount.setText("03");
        alertCount.setText("01");

        // Set Pie Chart Data
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("Active", 12),
                new PieChart.Data("Completed", 5),
                new PieChart.Data("Pending", 3)
        );
        projectPie.setData(pieData);

        // Set Line Chart Data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Submissions");
        series.getData().add(new XYChart.Data<>("Jan", 5));
        series.getData().add(new XYChart.Data<>("Feb", 8));
        series.getData().add(new XYChart.Data<>("Mar", 12));
        series.getData().add(new XYChart.Data<>("Apr", 15));

        studentProgressChart.getData().add(series);
    }

    // --- Navigation Methods ---

    @FXML
    public void showStudents(ActionEvent event) {
        // Already on Dashboard
        setActiveButton(btnDashboard);
    }

    @FXML
    public void showPending(ActionEvent event) throws IOException {
        setActiveButton(btnPending);
        // Load AllSubmissionController.fxml
        // switchScene(event, "AllSubmissionController.fxml", "All Submissions");
       // System.out.println("Navigating to All Submissions...");
        // আপনি যখন ওই FXML ফাইল বানাবেন তখন উপরের কমেন্ট আউট করা লাইনটি চালু করবেন
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AllSubmissionController.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Teacher Dashboard");
        if (stage.isMaximized()) {
            stage.setMaximized(false); // একটু ছোট করুন
            stage.setMaximized(true);  // আবার বড় করুন (এতে কন্টেন্ট সেন্টারে চলে আসবে)
        } else {
            stage.setMaximized(true);
        }
        stage.show();

    }

    @FXML
    public void showSupervisorSlots(ActionEvent event) {
        setActiveButton(btnSlots);
        System.out.println("Navigating to Supervisor Slots...");
    }

    @FXML
    public void showPostIdea(ActionEvent event) {
        setActiveButton(btnPostIdea);
        System.out.println("Navigating to Post Idea...");
    }

    @FXML
    public void showSettings(ActionEvent event) {
        setActiveButton(btnSettings);
        System.out.println("Navigating to Settings...");
    }

    @FXML
    public void handleLogout(ActionEvent event) throws IOException {
        // Redirect to Login Page
        switchScene(event, "teacher_login.fxml", "Teacher Login");
    }

    // --- Helper Methods ---

    // This method handles the Button Styling (White vs Transparent)
    private void setActiveButton(Button activeButton) {
        // 1. Reset all buttons to default style (Transparent, Light Text)
        String defaultStyle = "-fx-background-color: transparent; -fx-text-fill: #e2e8f0; -fx-background-radius: 8; -fx-cursor: hand;";

        btnDashboard.setStyle(defaultStyle);
        btnPending.setStyle(defaultStyle);
        btnSlots.setStyle(defaultStyle);
        btnPostIdea.setStyle(defaultStyle);
        btnSettings.setStyle(defaultStyle);

        // 2. Set the clicked button to Active style (White, Dark Text, Shadow)
        String activeStyle = "-fx-background-color: #ffffff; -fx-text-fill: #1e293b; -fx-background-radius: 8; -fx-cursor: hand; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 5, 0, 0, 2); -fx-font-weight: bold;";

        activeButton.setStyle(activeStyle);
    }

    // Scene Switching with Maximize Fix
    private void switchScene(ActionEvent event, String fxmlFile, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Keep maximize state
        boolean wasMaximized = stage.isMaximized();

        stage.setScene(new Scene(root));
        if (title != null) stage.setTitle(title);

        // Maximize Fix logic
        if (wasMaximized) {
            stage.setMaximized(false);
            stage.setMaximized(true);
        } else {
            stage.setMaximized(true);
        }

        stage.show();
    }
}