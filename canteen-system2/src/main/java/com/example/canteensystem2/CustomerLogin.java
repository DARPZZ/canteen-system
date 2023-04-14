package com.example.canteensystem2;

import javafx.scene.control.TextField;

public class CustomerLogin extends LoginScreen
{
    private TextField employeeIdTf;
    public CustomerLogin()
    {
        super.setHeaderText("Kundeportal \n\tlogin");
        super.setLoginNotificationText("Indtast venligst dit medarbejder id");

        // Creates username textfield
        employeeIdTf = new TextField();
        super.getLoginAp().getChildren().add(employeeIdTf);
        employeeIdTf.setPromptText("Brugernavn");
        employeeIdTf.setPrefSize(250, 40);
        employeeIdTf.setLayoutX((super.getScene().getWidth() - employeeIdTf.getPrefWidth()) / 2);
        employeeIdTf.setLayoutY(400);
        employeeIdTf.setFocusTraversable(false);
    }
}
