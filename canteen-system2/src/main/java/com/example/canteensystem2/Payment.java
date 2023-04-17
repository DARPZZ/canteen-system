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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    Label Saldo = new Label();
    Button kr50 = new Button("50,-");
    Button kr100 = new Button("100,-");
    Button kr200 = new Button("200,-");
    CustommerLogin custommerLogin = new CustommerLogin(stage);
    private final int PREF_HEIGHT = 50;
    private final int PREF_WIDTH = 100;
    private float newBalance = 0.0f;
    TextField customAmount = new TextField();
    public Scene PaymentScene() {
        return scene;
    }

    public Payment(Stage stage, TextField textField) {
        this.stage = stage;
        Welcome.setLayoutY(50);
        Welcome.setLayoutX(400);
        borderPane.setCenter(anchorPane);

        Welcome.setId("welcomeText");
        Saldo.setId("saldo");
        getUserID(textField);
        kr50.setLayoutY(300);
        kr50.setLayoutX(1170);
        kr50.setPrefWidth(PREF_WIDTH);
        kr50.setPrefHeight(PREF_HEIGHT);
        kr50.setId("saldoButtons");

        kr100.setLayoutY(kr50.getLayoutY() + 70);
        kr100.setLayoutX(kr50.getLayoutX());
        kr100.setPrefHeight(PREF_HEIGHT);
        kr100.setPrefWidth(PREF_WIDTH);
        kr100.setId("saldoButtons");

        kr200.setLayoutY(kr100.getLayoutY() + 70);
        kr200.setLayoutX(kr100.getLayoutX());
        kr200.setPrefHeight(PREF_HEIGHT);
        kr200.setPrefWidth(PREF_WIDTH);
        kr200.setId("saldoButtons");

        Saldo.setLayoutX(50);
        Saldo.setLayoutY(350);

        customAmount.setLayoutX(kr200.getLayoutX()-50);
        customAmount.setLayoutY(kr200.getLayoutY()+70);
        customAmount.setPromptText("Enter custom amount");
        customAmount.setPrefWidth(150);
        customAmount.setPrefHeight(35);
        anchorPane.getChildren().addAll(Welcome, kr50, kr100, kr200, Saldo,customAmount);
        scene = new Scene(borderPane, 1280, 768);

    }
    public void getUserID(TextField textField) {
        int employeeId = Integer.parseInt(textField.getText());
        Employee employee = (Employee) pdEmployee.Get(employeeId);
        if (employee != null) {
            newBalance = employee.getSaldo();
            Saldo.setText("Welcome: " + employee.getName() + "\n" +  "Your balance is: " + newBalance);
        } else {
            Saldo.setText("No employee with ID " + employeeId + " found.");
        }
        kr50.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newBalance += 50;
                pdEmployee.Update(employee, "fldSaldo", String.valueOf(newBalance));
                Saldo.setText("Welcome: " + employee.getName() + "\n" +  "Your balance is: " + newBalance);
            }
        });
        kr100.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newBalance += 100;
                pdEmployee.Update(employee, "fldSaldo", String.valueOf(newBalance));
                Saldo.setText("Welcome: " + employee.getName() + "\n" +  "Your balance is: " + newBalance);

            }
        });
        kr200.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newBalance += 200;
                pdEmployee.Update(employee, "fldSaldo", String.valueOf(newBalance));
                Saldo.setText("Welcome: " + employee.getName() + "\n" +  "Your balance is: " + newBalance);
            }
        });
        customAmount.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent keyEvent)
            {
                if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                    newBalance += Float.parseFloat(customAmount.getText());
                    pdEmployee.Update(employee, "fldSaldo", String.valueOf(newBalance));
                    Saldo.setText("Welcome: " + employee.getName() + "\n" +  "Your balance is: " + newBalance);
                    customAmount.setText("");
                }
            }
        });
    }
}


