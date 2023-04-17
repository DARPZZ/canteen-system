package View;

import com.example.canteensystem2.HelloApplication;
import com.example.canteensystem2.SceneName;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CustomerLogin extends LoginScreen
{
    private TextField employeeIdTf;
    private Button signInBtn;
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

        // Creates sign in button
        signInBtn = new Button("Log ind");
        super.getLoginAp().getChildren().add(signInBtn);
        signInBtn.setPrefSize(250, 40);
        signInBtn.setLayoutX((super.getScene().getWidth() - signInBtn.getPrefWidth()) / 2);
        signInBtn.setLayoutY(450);
        signInBtn.setOnAction(event -> HelloApplication.changeScene(SceneName.Payment));
    }
}
