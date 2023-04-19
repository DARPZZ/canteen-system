package com.example.canteensystem2;

import View.LoginScreen;
import com.example.canteensystem2.Payment;
import javafx.scene.control.Button;

import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerLogin extends LoginScreen
{
    private Button signInBtn;
    Payment payment = new Payment();
  private Stage stage;

    public TextField getEmployeeIdTf()
    {
        return employeeIdTf;
    }

    public void setEmployeeIdTf(TextField employeeIdTf)
    {
        this.employeeIdTf = employeeIdTf;
    }

    private TextField employeeIdTf;
    public CustomerLogin(Stage stage)
    {

        super.setHeaderText("Kundeportal \n\tlogin");
        super.setLoginNotificationText("Indtast venligst dit medarbejder id");

        // Creates username textfield
        employeeIdTf = new TextField();
        super.getLoginAp().getChildren().add(employeeIdTf);
        employeeIdTf.setPromptText("Brugernavn");
        employeeIdTf.setPrefSize(250, 40);
        employeeIdTf.setLayoutX((super.getScene().getWidth() - employeeIdTf.getPrefWidth()) / 2);
        employeeIdTf.setLayoutY(350);
        employeeIdTf.setFocusTraversable(false);

        signInBtn = new Button("Log ind");
        super.getLoginAp().getChildren().add(signInBtn);
        signInBtn.setPrefSize(250, 40);
        signInBtn.setLayoutX((super.getScene().getWidth() - signInBtn.getPrefWidth()) / 2);
        signInBtn.setLayoutY(450);
        signInBtn.setId("loginButtons");

        signInBtn.setOnAction(event ->
        {
            Scene createPaymentScene = payment.createPaymentScene(stage, employeeIdTf);
            stage.setScene(createPaymentScene);
            employeeIdTf.clear();
        });
    }
}
