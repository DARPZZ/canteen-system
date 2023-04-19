package View;



import com.example.canteensystem2.HelloApplication;
import com.example.canteensystem2.SceneName;
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

    public LoginScreen()
    {
        loginAp = new AnchorPane();
        scene = new Scene(loginAp, 1280, 768);
        loginAp.setPrefSize(scene.getWidth(), scene.getHeight());
        loginAp.setOnMousePressed(event -> loginAp.requestFocus());

        // Header label to set new text
        headerLabel = new Label();
        loginAp.getChildren().add(headerLabel);
        headerLabel.setPrefSize(250, 200);
        headerLabel.setLayoutX((scene.getWidth() / 2) - (headerLabel.getPrefWidth() / 2) + 15);
        headerLabel.setLayoutY(100);
        headerLabel.setStyle("-fx-font-size: 40; -fx-font-family: calibri; -fx-font-weight: Bold");
        headerLabel.setId("headerLabel");

        // Login notification label
        loginNotificationLabel = new Label();
        loginAp.getChildren().add(loginNotificationLabel);
        loginNotificationLabel.setPrefSize(300, 100);
        loginNotificationLabel.setLayoutX((scene.getWidth() / 2) - (loginNotificationLabel.getPrefWidth()/2) + 30);
        loginNotificationLabel.setLayoutY(headerLabel.getLayoutY() + 150);
        loginNotificationLabel.setId("loginNotificationLabel");

        // Creates the back button
        backBtn = new BackButton();
        loginAp.getChildren().add(backBtn);

        backBtn.setLayoutX(50);
        backBtn.setLayoutY(25);
        backBtn.setOnAction(event -> HelloApplication.changeScene(SceneName.LogIn));
        String css = this.getClass().getResource("/com/example/canteensystem2/Style.css").toExternalForm();
        scene.getStylesheets().add(css);
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
