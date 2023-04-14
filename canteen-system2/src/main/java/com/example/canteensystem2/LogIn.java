package com.example.canteensystem2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LogIn extends Application
{
Button adminLoginB = new Button("Admin login");
Button customerLoginB = new Button("Custommer login");

    @Override
    public void start(Stage stage) throws IOException
    {
        BorderPane borderPane = new BorderPane();
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(borderPane, 1280, 768);
        Label welcome = new Label("Welcome to Canteen ");
        Label choice = new Label("Please select what you would like to log in as");
        borderPane.setCenter(anchorPane);
        anchorPane.getChildren().addAll(adminLoginB, customerLoginB,welcome,choice);


        adminLoginB.setLayoutY(300);
        adminLoginB.setPrefWidth(150);
        adminLoginB.setPrefHeight(20);
        adminLoginB.setLayoutX(scene.getWidth()/2 -(adminLoginB.getPrefWidth()/2) );

        customerLoginB.setLayoutX(adminLoginB.getLayoutX());
        customerLoginB.setLayoutY(adminLoginB.getLayoutY()+50);
        customerLoginB.setPrefHeight(adminLoginB.getPrefHeight());
        customerLoginB.setPrefWidth(adminLoginB.getPrefWidth());

        welcome.setLayoutX(adminLoginB.getLayoutX()+20);
        welcome.setLayoutY(adminLoginB.getLayoutY()-100);

        choice.setLayoutX(adminLoginB.getLayoutX()-40);
        choice.setLayoutY(adminLoginB.getLayoutY()-20);



        //region sceneShift
        customerLoginB.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                CustommerLogin custommerLogin = new CustommerLogin(stage);
                Scene sceneCustommerLogin = custommerLogin.custommerLogin();
                stage.setScene(sceneCustommerLogin);

            }

        });
        adminLoginB.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                AdminLogin adminLogin = new AdminLogin();
                Scene sceneAdminLogin = adminLogin.adminLogin();

            }
        });

        //endregion
        stage.setTitle("Canteen-system!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args)
    {
        launch();
    }
}