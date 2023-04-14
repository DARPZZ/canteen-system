package com.example.canteensystem2;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public abstract class LoginScreen
{
    private Scene scene;
    private AnchorPane loginAp;
    private Label headerLabel;
    private Label loginNotificationLabel;
    private TextField usernameTf;
    private TextField loginTf;

    public LoginScreen()
    {
        loginAp = new AnchorPane();
        scene = new Scene(loginAp, 1280, 768);

        // Creates default header and textfields for inputs
        loginNotificationLabel = new Label("Indtast venligst dine login oplysninger");
        loginNotificationLabel.setPrefSize(scene.getWidth() / 4, scene.getHeight() / 4);
        loginNotificationLabel.setLayoutX(scene.getWidth() / 2);
        loginNotificationLabel.setStyle("-fx-font-size: 14; -fx-font-family: calibri");

        // Creates username textfield
        usernameTf = new TextField();
        usernameTf.setPromptText("Brugernavn");
        usernameTf.setPrefSize(150, 30);
        usernameTf.setLayoutX(scene.getWidth() / 2);
        usernameTf.setLayoutY(scene.getHeight() / 2);

        // Creates password textfield
        loginTf = new TextField();
        loginTf.setPromptText("Kodeord");
        loginTf.setPrefSize(usernameTf.getPrefWidth(), usernameTf.getPrefHeight());
        loginTf.setLayoutX(usernameTf.getLayoutX());
        loginTf.setLayoutY(usernameTf.getLayoutY() + usernameTf.getHeight());

        // Header label to set new text
        headerLabel = new Label();
        headerLabel.setStyle("-fx-font-size: 40; -fx-font-family: calibri");
        headerLabel.setPrefSize(scene.getWidth() / 2, scene.getHeight() / 3);
        headerLabel.setLayoutX(loginTf.getLayoutX());

        loginAp.getChildren().addAll(headerLabel, loginNotificationLabel, usernameTf, loginTf);
    }

    public void setHeaderText(String text)
    {
        this.headerLabel.setText(text);
    }

    public Scene getScene()
    {
        return scene;
    }
}
