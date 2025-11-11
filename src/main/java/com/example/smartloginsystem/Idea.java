package com.example.smartloginsystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Idea {
    private final StringProperty teacherName;
    private final StringProperty title;
    private final StringProperty description;

    public Idea(String teacherName, String title, String description) {
        this.teacherName = new SimpleStringProperty(teacherName);
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
    }

    // Property getters (IMPORTANT for TableView)
    public StringProperty teacherNameProperty() { return teacherName; }
    public StringProperty titleProperty() { return title; }
    public StringProperty descriptionProperty() { return description; }

    // Regular getters
    public String getTeacherName() { return teacherName.get(); }
    public String getTitle() { return title.get(); }
    public String getDescription() { return description.get(); }

    // Setters
    public void setTeacherName(String teacherName) { this.teacherName.set(teacherName); }
    public void setTitle(String title) { this.title.set(title); }
    public void setDescription(String description) { this.description.set(description); }
}