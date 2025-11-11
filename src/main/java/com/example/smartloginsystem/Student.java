package com.example.smartloginsystem;

public class Student {
    public  String username;
    public  String password;

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
