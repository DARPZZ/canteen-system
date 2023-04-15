package com.example.canteensystem2;

import View.AdminLogin;
import View.CustomerLogin;
import View.InventoryManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 768);
        scene = new InventoryManagement().getScene();

        String css = this.getClass().getResource("/com/example/canteensystem2/style.css").toExternalForm();
        scene.getStylesheets().add(css);



        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}