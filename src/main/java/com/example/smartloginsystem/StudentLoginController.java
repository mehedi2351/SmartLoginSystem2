package com.example.smartloginsystem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class StudentLoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private final String STUDENTS_FILE = "students.json";

    @FXML
    public void handleLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Enter username and password");
            return;
        }

        List<Student> students = readStudentsFromJson();
        if (students == null || students.isEmpty()) {
            showAlert("No registered users. Please register first!");
            return;
        }

        boolean found = false;
        for (Student s : students) {
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                found = true;
                break;
            }
        }

        if (found) {
            switchScene(event, "dashboard.fxml", "Dashboard");
            if (stage.isMaximized()) {
                stage.setMaximized(false); // একটু ছোট করুন
                stage.setMaximized(true);  // আবার বড় করুন (এতে কন্টেন্ট সেন্টারে চলে আসবে)
            } else {
                stage.setMaximized(true);
            }

        } else {
            showAlert("Wrong Username or Password");
        }
    }

    private List<Student> readStudentsFromJson() {
        File file = new File(STUDENTS_FILE);
        if (!file.exists()) return null;
        try (Reader reader = new FileReader(file, StandardCharsets.UTF_8)) {
            return new Gson().fromJson(reader, new TypeToken<List<Student>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    public void handleRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student_register.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));

        // ফিক্স: এখানে Maximized করা হয়েছে যাতে উইন্ডো ছোট না হয়
     //   stage.setMaximized(true);
        if (stage.isMaximized()) {
            stage.setMaximized(false); // একটু ছোট করুন
            stage.setMaximized(true);  // আবার বড় করুন (এতে কন্টেন্ট সেন্টারে চলে আসবে)
        } else {
            stage.setMaximized(true);
        }
        stage.show();
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));

        // ফিক্স: এখানে Maximized করা হয়েছে
        if (stage.isMaximized()) {
            stage.setMaximized(false); // একটু ছোট করুন
            stage.setMaximized(true);  // আবার বড় করুন (এতে কন্টেন্ট সেন্টারে চলে আসবে)
        } else {
            stage.setMaximized(true);
        }
        stage.show();
    }

    private void switchScene(ActionEvent event, String fxmlFile, String title) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        if (title != null) stage.setTitle(title);

        // ফিক্স: ড্যাশবোর্ডে যাওয়ার সময়ও স্ক্রিন ফুল থাকবে
        stage.setMaximized(true);
        stage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}