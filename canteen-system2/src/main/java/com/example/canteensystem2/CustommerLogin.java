package com.example.canteensystem2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.IllegalFormatCodePointException;


public class CustommerLogin {
    private Scene scene;
    private Stage stage;
    private TextField textField = new TextField();

    public CustommerLogin(Stage stage) {
        this.stage = stage;

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(textField);
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    Payment payment = new Payment(stage, textField);
                    Scene paymentScene = payment.PaymentScene();
                    stage.setScene(paymentScene);
                }
            }
        });

        scene = new Scene(anchorPane, 400, 400);
    }

    public TextField getTextField() {
        return textField;
    }

    public Scene custommerLogin() {
        return scene;
    }
}

