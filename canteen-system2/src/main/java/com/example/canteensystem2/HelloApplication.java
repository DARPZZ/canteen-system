package com.example.canteensystem2;

import DaOImplements.DaOItem;
import DaoObjects.DaOInterface;
import DaoObjects.Item;
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
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        Item i = new Item(1,"mælk",3.4f );
        DaOItem worker = new DaOItem();
        worker.Create(i);
    }

    public static void main(String[] args)
    {
        launch();
    }
}