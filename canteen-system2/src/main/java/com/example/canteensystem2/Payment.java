package com.example.canteensystem2;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Payment
{

    private Scene scene;
    private Stage stage;
    BorderPane borderPane = new BorderPane();
    AnchorPane anchorPane = new AnchorPane();
    Label Welcome = new Label("Velkommen til Canteen Systems Kundeport");
    Label Saldo = new Label();
    Button kr50 = new Button("50.kr");
    Button kr100 = new Button("100.kr");
    Button kr200 = new Button("200.kr");

    private final int PREF_HEIGHT =50;
    private final int PREF_WIDTH = 100;
    public Scene PaymentScene() {
        return scene;
    }
    public Payment(Stage stage)
    {

        this.stage = stage;
        Welcome.setLayoutY(100);
        Welcome.setLayoutX(550);
        borderPane.setCenter(anchorPane);


        kr50.setLayoutY(300);
        kr50.setLayoutX(1170);
        kr50.setPrefWidth(PREF_WIDTH);
        kr50.setPrefHeight(PREF_HEIGHT);


        kr100.setLayoutY(kr50.getLayoutY()+70);
        kr100.setLayoutX(kr50.getLayoutX());
        kr100.setPrefHeight(PREF_HEIGHT);
        kr100.setPrefWidth(PREF_WIDTH);

        kr200.setLayoutY(kr100.getLayoutY()+70);
        kr200.setLayoutX(kr100.getLayoutX());
        kr200.setPrefHeight(PREF_HEIGHT);
        kr200.setPrefWidth(PREF_WIDTH);

        anchorPane.getChildren().addAll(Welcome,kr50,kr100,kr200,Saldo);

        scene = new Scene(borderPane, 1280, 768);



    }


}
