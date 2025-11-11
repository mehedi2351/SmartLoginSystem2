package com.example.smartloginsystem;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.EventObject;

public class DashboardController {

    @FXML private PieChart statusPie;
    @FXML private LineChart<String, Number> ideasChart;
    @FXML private ListView<String> recentList;
    @FXML private ImageView avatarView;
    @FXML private Label userNameLabel;
    @FXML private Label userRoleLabel;
    @FXML private Label submittedCount;
    @FXML private Label pendingCount;
    @FXML private Label approvedCount;
    @FXML private Label supervisorReq;

    @FXML
    public void initialize() {
        // header info
        userNameLabel.setText("Md mehedi");
        userRoleLabel.setText("Cse 2023");

        // load avatar (resource)
        try (InputStream in = getClass().getResourceAsStream("/com/example/smartloginsystem/img.png")) {
            if (in != null) avatarView.setImage(new Image(in));
        } catch (Exception ignored) {}

        // sample summary numbers
        submittedCount.setText("3 Ideas");
        pendingCount.setText("2 Pending");
        approvedCount.setText("1 Approved");
        supervisorReq.setText("1 Active Request");

        // recent activity
        recentList.setItems(FXCollections.observableArrayList(
                "You submitted AI-based Smart Campus System (10 Oct)",
                "Your supervisor request to Dr. Rahman is pending.",
                "Similarity alert for IoT Bus Tracker (82% match)"
        ));

        // pie chart sample
        PieChart.Data a = new PieChart.Data("Approved", 1);
        PieChart.Data b = new PieChart.Data("Pending", 2);
        PieChart.Data c = new PieChart.Data("Rejected", 0.5);
        statusPie.setData(FXCollections.observableArrayList(a, b, c));

        // line chart sample (ideas per month)
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Ideas Submitted");
        series.getData().add(new XYChart.Data<>("Jan", 2));
        series.getData().add(new XYChart.Data<>("Feb", 3));
        series.getData().add(new XYChart.Data<>("Mar", 1));
        series.getData().add(new XYChart.Data<>("Apr", 4));
        series.getData().add(new XYChart.Data<>("May", 6));
        series.getData().add(new XYChart.Data<>("Jun", 8));
        ideasChart.getData().add(series);
    }
   



    @FXML


    public void openFindSupervisor(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("find-supervisor.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Find Supervisor");
        stage.show();
    }
    public void handleLogout(ActionEvent actionEvent) throws  IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Find Supervisor");
        stage.show();
    }
    public void opensubmitted(ActionEvent actionEvent) throws  IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("project_submitted.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Find Supervisor");
        stage.show();
    }
    public void openproject(ActionEvent actionEvent) throws  IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View_Post.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Find Supervisor");
        stage.show();
    }



}
