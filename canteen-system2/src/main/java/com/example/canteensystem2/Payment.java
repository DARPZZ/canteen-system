package com.example.canteensystem2;

import DaOImplements.DaOEmployee;
import DaoObjects.DaOInterface;
import DaoObjects.Employee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class Payment {
    DaOInterface pdEmployee = new DaOEmployee();
    private Scene scene;
    private Stage stage;
    BorderPane borderPane = new BorderPane();
    AnchorPane anchorPane = new AnchorPane();
    Label Welcome = new Label("Velkommen til Canteen Systems Kundeport");
    public Label Saldo = new Label();
    Button kr50 = new Button("50.kr");
    Button kr100 = new Button("100.kr");
    Button kr200 = new Button("200.kr");
    CustommerLogin custommerLogin = new CustommerLogin(stage);
    private final int PREF_HEIGHT = 50;
    private final int PREF_WIDTH = 100;
    private float newSaldo = 0;

    public Scene PaymentScene() {
        return scene;
    }

    public Payment(Stage stage, TextField textField) {
        this.stage = stage;
        Welcome.setLayoutY(100);
        Welcome.setLayoutX(550);
        borderPane.setCenter(anchorPane);

        getUserID(textField);
        kr50.setLayoutY(300);
        kr50.setLayoutX(1170);
        kr50.setPrefWidth(PREF_WIDTH);
        kr50.setPrefHeight(PREF_HEIGHT);

        kr100.setLayoutY(kr50.getLayoutY() + 70);
        kr100.setLayoutX(kr50.getLayoutX());
        kr100.setPrefHeight(PREF_HEIGHT);
        kr100.setPrefWidth(PREF_WIDTH);

        kr200.setLayoutY(kr100.getLayoutY() + 70);
        kr200.setLayoutX(kr100.getLayoutX());
        kr200.setPrefHeight(PREF_HEIGHT);
        kr200.setPrefWidth(PREF_WIDTH);

        anchorPane.getChildren().addAll(Welcome, kr50, kr100, kr200, Saldo);


        scene = new Scene(borderPane, 1280, 768);
    }
    public void getUserID(TextField textField) {
        int employeeId = Integer.parseInt(textField.getText());
        Employee employee = (Employee) pdEmployee.Get(employeeId);
        Saldo.textProperty().bind(employee.getSaldo().asString());
       /*
        if (employee != null) {
            Saldo.setText("Welcome: " + employee.getName() + "Youre  balance Is " + employee.getSaldo());
        } else {
            Saldo.setText("No employee with ID " + employeeId + " found.");
        }

        */
        kr50.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                float newBalance = employee.getSaldo().floatValue() + 50;
                pdEmployee.Update(employee,"fldSaldo", String.valueOf(newBalance));
                Saldo.setText("Welcome: " + employee.getName() + "Youre  balance Is " + newBalance);
            }
        });
        kr100.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                float newBalance = employee.getSaldo().floatValue() + 100;
                pdEmployee.Update(employee,"fldSaldo", String.valueOf(newBalance));
                Saldo.setText("Welcome: " + employee.getName() + "Youre  balance Is " + newBalance);
            }
        });
        kr200.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                float newBalance = employee.getSaldo().floatValue() + 200;
                pdEmployee.Update(employee,"fldSaldo", String.valueOf(newBalance));
                Saldo.setText("Welcome: " + employee.getName() + "Youre  balance Is " + newBalance);
            }
        });
    }

}

