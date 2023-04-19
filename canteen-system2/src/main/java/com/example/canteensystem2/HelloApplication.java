package com.example.canteensystem2;

import View.AdminLogin;
import View.CustomerLogin;
import View.InventoryManagement;
import View.SalesHistory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class HelloApplication extends Application
{

    static Stage primaryStageHolder = null;
    static HashMap<SceneName, Scene> sceneMap = new HashMap<>();

    @Override
    public void start(Stage stage) throws IOException
    {
        primaryStageHolder = stage;

       Scene scene = new LogIn().getScene();

        sceneMap.put(SceneName.InventoryManagement, new InventoryManagement().getScene());
        sceneMap.put(SceneName.CustomerLogin, new CustomerLogin(stage).getScene());
        sceneMap.put(SceneName.AdminLogin, new AdminLogin().getScene());
        sceneMap.put(SceneName.LogIn, new LogIn().getScene());
        sceneMap.put(SceneName.SalesHistory, new SalesHistory().getScene());
        sceneMap.put(SceneName.PointOfSales, new PointOfSale().getScene());
       // sceneMap.put(SceneName.Payment, new Payment().getScene());
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Kantinen");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args)
    {
        launch();
    }

    public static void changeScene(SceneName sceneName)
    {
        if (sceneMap.containsKey(sceneName))
        {
            primaryStageHolder.setScene(sceneMap.get(sceneName));
        }
    }
}