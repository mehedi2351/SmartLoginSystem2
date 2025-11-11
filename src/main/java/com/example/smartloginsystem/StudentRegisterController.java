package com.example.smartloginsystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentRegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private final String STUDENTS_FILE = "students.json"; // Same path for read/write

    @FXML
    public void handleRegister(ActionEvent event) throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String confirmPassword = confirmPasswordField.getText().trim();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert("Please fill in all fields!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert("Passwords do not match!");
            return;
        }

        List<Student> students = readStudentsFromJson();

        // Check for duplicate username
        for (Student s : students) {
            if (s.getUsername().equals(username)) {
                showAlert("Username already exists!");
                return;
            }
        }

        // Add new student
        students.add(new Student(username, password));

        // Save to JSON
        saveStudentsToJson(students);

        showInfo("Registration Successful! You can now log in.");

        // Redirect to login
        goToLogin(event);
    }

    private List<Student> readStudentsFromJson() {
        File file = new File(STUDENTS_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (Reader reader = new FileReader(file, StandardCharsets.UTF_8)) {
            return new Gson().fromJson(reader, new TypeToken<List<Student>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveStudentsToJson(List<Student> students) {
        try (Writer writer = new FileWriter(STUDENTS_FILE, StandardCharsets.UTF_8)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(students, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Registration Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration Successful");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void goToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student_login.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
