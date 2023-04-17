package View;

import com.example.canteensystem2.HelloApplication;

import com.example.canteensystem2.SceneName;
import javafx.scene.control.Button;

import com.example.canteensystem2.Payment;
import com.example.canteensystem2.SceneName;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CustomerLogin extends LoginScreen
{
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
        this.stage = stage;
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


        employeeIdTf.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event)
            {
                if (event.getCode() == KeyCode.ENTER) {
                    Scene createPaymentScene = payment.createPaymentScene(stage,employeeIdTf);
                    stage.setScene(createPaymentScene);
                }
            }
        });

    }
}
