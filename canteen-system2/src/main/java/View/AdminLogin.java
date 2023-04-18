package View;

import Model.DaOImplements.DaOEmployee;
import Model.DaoObjects.Employee;
import com.example.canteensystem2.HelloApplication;
import com.example.canteensystem2.SceneName;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;

import java.util.List;

public class AdminLogin extends LoginScreen
{
    private TextField usernameTf;
    private TextField loginTf;
    private Button signInBtn;
    private List<Employee> employeeList;
    public AdminLogin()
    {
        super.setHeaderText("Administrator \n\tlogin");
        super.setLoginNotificationText("Indtast venligst dine login oplysninger");
        employeeList = new DaOEmployee().GetAll();
        // Creates username textfield
        usernameTf = new TextField();
        super.getLoginAp().getChildren().add(usernameTf);
        usernameTf.setPromptText("Brugernavn");
        usernameTf.setPrefSize(250, 40);
        usernameTf.setLayoutX((super.getScene().getWidth() - usernameTf.getPrefWidth()) / 2);
        usernameTf.setLayoutY(350);
        usernameTf.setFocusTraversable(false);
        usernameTf.setOnKeyReleased(event ->
        {
            if (event.getCode() == KeyCode.ENTER)
            {
                signInBtn.fire();
            }
        });

        // Creates password textfield
        loginTf = new TextField();
        super.getLoginAp().getChildren().add(loginTf);
        loginTf.setPromptText("Kodeord");
        loginTf.setPrefSize(usernameTf.getPrefWidth(), usernameTf.getPrefHeight());
        loginTf.setLayoutX(usernameTf.getLayoutX());
        loginTf.setLayoutY((usernameTf.getLayoutY() + 50));
        loginTf.setFocusTraversable(false);
        loginTf.setOnKeyReleased(event ->
        {
            if (event.getCode() == KeyCode.ENTER)
            {
                signInBtn.fire();
            }
        });

        // Creates sign in button
        signInBtn = new Button("Log ind");
        super.getLoginAp().getChildren().add(signInBtn);
        signInBtn.setPrefSize(250, 40);
        signInBtn.setLayoutX((super.getScene().getWidth() - signInBtn.getPrefWidth()) / 2);
        signInBtn.setLayoutY(450);
        signInBtn.setOnAction(event ->
        {
            if (validatePassword(usernameTf.getText(), loginTf.getText()))
            {
                usernameTf.clear();
                loginTf.clear();
                usernameTf.setStyle("-fx-background-color: white");
                loginTf.setStyle("-fx-background-color: white");
                HelloApplication.changeScene(SceneName.InventoryManagement);
            }
            else
            {
                usernameTf.setTooltip(new Tooltip("Forkert brugernavn eller kode"));
                usernameTf.setStyle("-fx-background-color: red");
                loginTf.setStyle("-fx-background-color: red");
            }
        });
    }

    public boolean validatePassword(String name, String password)
    {
        for (Employee employee : employeeList)
        {
            if (name.equalsIgnoreCase(String.valueOf(employee.getEmployeeID())) && password.equalsIgnoreCase(employee.getPassword()))
            {
                return true;
            }
        }
        return false;
    }
}
