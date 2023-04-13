package com.example.canteensystem2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LogIn extends Application
{
Button adminLoginB = new Button();
Button customerLoginB = new Button();



    @Override
    public void start(Stage stage) throws IOException
    {

        BorderPane borderPane = new BorderPane();
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(borderPane, 1280, 768);
        borderPane.setCenter(anchorPane);
        anchorPane.getChildren().addAll(adminLoginB, customerLoginB);

        //region sceneShift
        customerLoginB.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                CustommerLogin custommerLogin = new CustommerLogin();
                Scene sceneCustommerLogin = custommerLogin.custommerLogin();
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