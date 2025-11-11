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
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewPostController {

    @FXML
    private TableView<Idea> ideaTable;
    @FXML
    private TableColumn<Idea, String> teacherCol;
    @FXML
    private TableColumn<Idea, String> titleCol;
    @FXML
    private TableColumn<Idea, String> descCol;

    @FXML
    public void initialize() {
        System.out.println("Initialize method called"); // Debug line

        // Set up the table columns with EXACT property names
        teacherCol.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Load and set data
        ObservableList<Idea> ideas = loadSampleData();
        ideaTable.setItems(ideas);

        System.out.println("Data loaded: " + ideas.size() + " items"); // Debug line
    }

    private ObservableList<Idea> loadSampleData() {
        ObservableList<Idea> ideas = FXCollections.observableArrayList();

        // Add sample data
        ideas.add(new Idea("Dr  ", "AI Chatbot Development", "Building an intelligent chatbot using machine learning and natural language processing"));
        ideas.add(new Idea("Mamun Sir", "E-Commerce Website", "Developing a full-stack e-commerce platform with payment gateway integration"));
        ideas.add(new Idea("Asis Sir", "Mobile Health App", "Creating a fitness tracking application with real-time health monitoring features"));
        ideas.add(new Idea("Nitu mam", "Food Delivery App", "Mobile application for food ordering and delivery tracking"));

        return ideas;
    }

    public void handleBackToDashboard(ActionEvent actionEvent) throws IOException {
        // Navigate back to dashboard
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Find Supervisor");
            stage.show();
        }
    }
}