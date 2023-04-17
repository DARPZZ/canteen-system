package com.example.canteensystem2;

import View.AdminLogin;
import View.CustomerLogin;
import View.InventoryManagement;
import javafx.animation.KeyValue;
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 768);
        scene = new InventoryManagement().getScene();

        String css = this.getClass().getResource("/com/example/canteensystem2/style.css").toExternalForm();
        scene.getStylesheets().add(css);


        sceneMap.put(SceneName.InventoryManagement, new InventoryManagement().getScene());
        sceneMap.put(SceneName.CustomerLogin, new CustomerLogin().getScene());
        sceneMap.put(SceneName.AdminLogin, new AdminLogin().getScene());

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args)
    {
        launch();
    }

    public static void changeScene(SceneName sceneName)
    {
        primaryStageHolder.setTitle(sceneName.toString());

        if (sceneMap.containsKey(sceneName))
        {
            primaryStageHolder.setScene(sceneMap.get(sceneName));
        }
    }
}