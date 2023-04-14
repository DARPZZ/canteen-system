package com.example.canteensystem2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    public LoginScreen()
    {
        loginAp = new AnchorPane();
        scene = new Scene(loginAp, 1280, 768);
        loginAp.setPrefSize(scene.getWidth(), scene.getHeight());

        // Header label to set new text
        headerLabel = new Label();
        loginAp.getChildren().add(headerLabel);
        headerLabel.setPrefSize(250, 200);
        headerLabel.setLayoutX((scene.getWidth() / 2) - (headerLabel.getPrefWidth() / 2) + 25);
        headerLabel.setLayoutY(100);
        headerLabel.setStyle("-fx-font-size: 40; -fx-font-family: calibri; -fx-font-weight: Bold");

        // Login notification label
        loginNotificationLabel = new Label();
        loginAp.getChildren().add(loginNotificationLabel);
        loginNotificationLabel.setPrefSize(250, 100);
        loginNotificationLabel.setLayoutX((scene.getWidth() / 2) - (loginNotificationLabel.getPrefWidth()/2) + 25);
        loginNotificationLabel.setLayoutY(headerLabel.getLayoutY() + 150);
        loginNotificationLabel.setStyle("-fx-font-size: 14; -fx-font-family: calibri; -fx-font-weight: Bold");
    }

    public void setHeaderText(String text)
    {
        this.headerLabel.setText(text);
    }

    public void setLoginNotificationText(String text)
    {
        this.loginNotificationLabel.setText(text);
    }

    public AnchorPane getLoginAp()
    {
        return loginAp;
    }

    public Scene getScene()
    {
        return scene;
    }
}
