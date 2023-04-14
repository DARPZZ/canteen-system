package com.example.canteensystem2;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AdminLogin extends LoginScreen
{
    private TextField usernameTf;
    private TextField loginTf;
    public AdminLogin()
    {
        super.setHeaderText("Administrator \n\tlogin");
        super.setLoginNotificationText("Indtast venligst dine login oplysninger");

        // Creates username textfield
        usernameTf = new TextField();
        super.getLoginAp().getChildren().add(usernameTf);
        usernameTf.setPromptText("Brugernavn");
        usernameTf.setPrefSize(250, 40);
        usernameTf.setLayoutX((super.getScene().getWidth() - usernameTf.getPrefWidth()) / 2);
        usernameTf.setLayoutY(350);
        usernameTf.setFocusTraversable(false);

        // Creates password textfield
        loginTf = new TextField();
        super.getLoginAp().getChildren().add(loginTf);
        loginTf.setPromptText("Kodeord");
        loginTf.setPrefSize(usernameTf.getPrefWidth(), usernameTf.getPrefHeight());
        loginTf.setLayoutX(usernameTf.getLayoutX());
        loginTf.setLayoutY((usernameTf.getLayoutY() + 50));
        loginTf.setFocusTraversable(false);
    }
}
