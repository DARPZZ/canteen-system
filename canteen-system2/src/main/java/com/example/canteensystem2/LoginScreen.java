package com.example.canteensystem2;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public abstract class LoginScreen
{
    private Scene scene;
    private AnchorPane loginAp;
    private Label headerLabel;
    private Label loginNotificationLabel;
    private Button backBtn;
    private Button signInBtn;

    public LoginScreen()
    {
        loginAp = new AnchorPane();
        scene = new Scene(loginAp, 1280, 768);
        loginAp.setPrefSize(scene.getWidth(), scene.getHeight());

        // Header label to set new text
        headerLabel = new Label();
        loginAp.getChildren().add(headerLabel);
        headerLabel.setPrefSize(250, 200);
        headerLabel.setLayoutX((scene.getWidth() / 2) - (headerLabel.getPrefWidth() / 2) + 15);
        headerLabel.setLayoutY(100);
        headerLabel.setStyle("-fx-font-size: 40; -fx-font-family: calibri; -fx-font-weight: Bold");

        // Login notification label
        loginNotificationLabel = new Label();
        loginAp.getChildren().add(loginNotificationLabel);
        loginNotificationLabel.setPrefSize(250, 100);
        loginNotificationLabel.setLayoutX((scene.getWidth() / 2) - (loginNotificationLabel.getPrefWidth()/2) + 15);
        loginNotificationLabel.setLayoutY(headerLabel.getLayoutY() + 150);
        loginNotificationLabel.setStyle("-fx-font-size: 14; -fx-font-family: calibri; -fx-font-weight: Bold");

        // Creates the back button
        backBtn = new BackButton();
        loginAp.getChildren().add(backBtn);
        backBtn.setLayoutX(50);
        backBtn.setLayoutY(50);
        //backBtn.getStyleClass().add("back-button");

        // Creates sign in button
        signInBtn = new Button("Log ind");
        loginAp.getChildren().add(signInBtn);
        signInBtn.setPrefSize(250, 40);
        signInBtn.setLayoutX((scene.getWidth() - signInBtn.getPrefWidth()) / 2);
        signInBtn.setLayoutY(450);
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
