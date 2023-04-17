package View;

import com.example.canteensystem2.HelloApplication;
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
  private Stage stage;
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
        employeeIdTf.setLayoutY(350);
        employeeIdTf.setFocusTraversable(false);

        employeeIdTf.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event)
            {
                if (event.getCode() == KeyCode.ENTER) {
                  HelloApplication.changeScene(SceneName.Payment);

                }
            }
        });
    }
}
