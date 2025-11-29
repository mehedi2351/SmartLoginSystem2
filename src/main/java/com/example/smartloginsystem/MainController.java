package com.example.smartloginsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MainController {

    private Stage stage;
    private Parent root;

    public void openStudentPanel(ActionEvent event) throws IOException {
        // আলাদা কোড না লিখে কমন মেথড কল করা হচ্ছে
        switchScene(event, "student_login.fxml");
    }

    public void openTeacherPanel(ActionEvent event) throws IOException {
        // আলাদা কোড না লিখে কমন মেথড কল করা হচ্ছে
        switchScene(event, "teacher_login.fxml");
    }

    // এই মেথডটি সব উইন্ডো সুইচ করার কাজ করবে এবং সেন্টারিং ফিক্স করবে
    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        // --- The FIX (ম্যাজিক ট্রিক) ---
        // জাভাএফএক্সকে জোর করে লেআউট রিক্যালকুলেট করানোর জন্য
        // আমরা ম্যাক্সিমাইজ অফ করে আবার অন করব।

        if (stage.isMaximized()) {
            stage.setMaximized(false); // একটু ছোট করুন
            stage.setMaximized(true);  // আবার বড় করুন (এতে কন্টেন্ট সেন্টারে চলে আসবে)
        } else {
            stage.setMaximized(true);
        }

        stage.show();
    }
}