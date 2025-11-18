package com.example.smartloginsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboradController implements Initializable {

    @FXML
    private TableView<Admin> mytable;

    @FXML
    private TableColumn<Admin, String> stduentid;
    @FXML
    private TableColumn<Admin, String> teacherid;
    @FXML
    private TableColumn<Admin, String> tittleid;
    @FXML
    private TableColumn<Admin, String> desid;
    @FXML
    private TableColumn<Admin, String> reactid;
    @FXML
    private TableColumn<Admin, String> viewid;
    @FXML
    private TableColumn<Admin, String> acid;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

        stduentid.setCellValueFactory(new PropertyValueFactory<>("studentid"));
        teacherid.setCellValueFactory(new PropertyValueFactory<>("techerid"));
        tittleid.setCellValueFactory(new PropertyValueFactory<>("tittleid"));
        desid.setCellValueFactory(new PropertyValueFactory<>("desid"));
        reactid.setCellValueFactory(new PropertyValueFactory<>("reactid"));
        viewid.setCellValueFactory(new PropertyValueFactory<>("viewid"));
        acid.setCellValueFactory(new PropertyValueFactory<>("acid"));

        mytable.setItems(loadSampleData());
    }

    private ObservableList<Admin> loadSampleData() {

        ObservableList<Admin> admin = FXCollections.observableArrayList();

        admin.add(new Admin(
                "Mehedi",
                "Mamun",
                "Bus Tracking",
                "Live bus tracking system in campus",
                "Agree",
                "view",
                "ok / rejected"
        ));

        return admin;
    }
}
