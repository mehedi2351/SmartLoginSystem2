module com.example.smartloginsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;
    // requires com.google.gson; // uncomment if needed

    // Allow JavaFX to access FXML controllers (reflection)
    opens com.example.smartloginsystem to javafx.fxml;
    opens com.smartlogin to javafx.fxml;
   // opens com.example.smartthesis to javafx.fxml;

    // Export packages for external access (if needed by other modules)
    exports com.example.smartloginsystem;
    exports com.smartlogin;
  //  exports com.example.smartthesis;
}
