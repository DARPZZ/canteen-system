package com.example.canteensystem2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LogIn
{
Button adminLoginB = new Button("Admin login");
Button customerLoginB = new Button("Kunde login");
Scene scene;

    public LogIn()
    {
        BorderPane borderPane = new BorderPane();
        AnchorPane anchorPane = new AnchorPane();
        scene = new Scene(borderPane, 1280, 768);
        Label welcome = new Label("Welcome to Canteen ");
        Label choice = new Label("Please select what you would like to log in as");
        welcome.setId("startLogin");
        choice.setId("startLogin");

        borderPane.setCenter(anchorPane);

        anchorPane.getChildren().addAll(adminLoginB, customerLoginB,welcome,choice);
        adminLoginB.setLayoutY(300);
        adminLoginB.setPrefWidth(150);
        adminLoginB.setPrefHeight(50);
        adminLoginB.setLayoutX(scene.getWidth()/2 -(adminLoginB.getPrefWidth()/2) );

        customerLoginB.setLayoutX(adminLoginB.getLayoutX());
        customerLoginB.setLayoutY(adminLoginB.getLayoutY()+70);
        customerLoginB.setPrefHeight(adminLoginB.getPrefHeight());
        customerLoginB.setPrefWidth(adminLoginB.getPrefWidth());

        welcome.setLayoutX(adminLoginB.getLayoutX()-30);
        welcome.setLayoutY(adminLoginB.getLayoutY()-200);


        choice.setLayoutX(adminLoginB.getLayoutX()-170);
        choice.setLayoutY(adminLoginB.getLayoutY()-70);
        customerLoginB.setId("loginButtons");
        adminLoginB.setId("loginButtons");
        String css = this.getClass().getResource("/com/example/canteensystem2/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        //region sceneShift
        customerLoginB.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                HelloApplication.changeScene(SceneName.CustomerLogin);
            }

        });
        adminLoginB.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                HelloApplication.changeScene(SceneName.AdminLogin);
            }
        });

        //endregion
    }

    public Scene getScene()
    {
        return scene;
    }

}