package com.example.smartloginsystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

public class Admin {

    private StringProperty studentid;
    private StringProperty techerid;
    private StringProperty tittleid;
    private StringProperty desid;

    private SimpleObjectProperty<Button> reactBtn;
    private SimpleObjectProperty<Button> viewBtn;
    private SimpleObjectProperty<Button> actionBtn;

    public Admin(String studentid, String techerid, String tittleid,
                 String desid, String reactText, String viewText, String actionText) {

        this.studentid = new SimpleStringProperty(studentid);
        this.techerid = new SimpleStringProperty(techerid);
        this.tittleid = new SimpleStringProperty(tittleid);
        this.desid = new SimpleStringProperty(desid);

        // ============================
        // 🔵 Teacher React Button
        // ============================
        Button react = new Button(reactText);
        react.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; " +
                "-fx-background-radius: 6;");
        react.setOnAction(e -> {
            System.out.println("Teacher React Clicked for: " + studentid);
        });
        // eikhne sampleobjectproperty use kra hoise kron raction button ta kivbe chnge hbe ta nojor e rakha
        //SimpleObjectProperty-এর মধ্যে রাখা কোনো অবজেক্ট বা ভ্যালু যখন পরিবর্তন হয়,
        // তখন এটি স্বয়ংক্রিয়ভাবে সেই পরিবর্তনটি ট্র্যাক বা লক্ষ্য করতে পারে
        this.reactBtn = new SimpleObjectProperty<>(react);

        // ============================
        // 🟢 View Button (Popup open)
        // ============================
        Button view = new Button("View");
        view.setStyle("-fx-background-color:#2ecc71; -fx-text-fill:white; -fx-background-radius: 6;");
        view.setOnAction(e -> {
            System.out.println("View Button Clicked for: " + studentid);
            // এখান থেকে popup open হবে Controller ব্যবহার করে
        });
        this.viewBtn = new SimpleObjectProperty<>(view);

        // ============================
        // 🟠 Admin Action Button
        // ============================
        Button acBtn = new Button("Approve / Reject");
        acBtn.setStyle("-fx-background-color:#e67e22; -fx-text-fill:white; -fx-background-radius: 6;");

        acBtn.setOnAction(e -> {
            System.out.println("Admin Action for: " + studentid);
            // এখান থেকে another popup open হবে (final approve/reject)
        });

        this.actionBtn = new SimpleObjectProperty<>(acBtn);
    }

    // Getter Properties (TableView binding এর জন্য)
    public StringProperty studentidProperty() { return studentid; }
    public StringProperty techeridProperty() { return techerid; }
    public StringProperty tittleidProperty() { return tittleid; }
    public StringProperty desidProperty() { return desid; }

    public SimpleObjectProperty<Button> reactBtnProperty() { return reactBtn; }
    public SimpleObjectProperty<Button> viewBtnProperty() { return viewBtn; }
    public SimpleObjectProperty<Button> actionBtnProperty() { return actionBtn; }
}
