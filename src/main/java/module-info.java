module pl.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.example;
    opens pl.example.controller;
    opens pl.example.model;
    opens pl.example.model.client;
}