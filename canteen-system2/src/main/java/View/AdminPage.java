package View;

import com.example.canteensystem2.HelloApplication;
import com.example.canteensystem2.SceneName;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public abstract class AdminPage
{
    Scene scene;
    AnchorPane anchorPane;
    Button pointOfSaleBtn;
    Button StockManagementBtn;
    Button SalesHistoryBtn;
    Button backBtn;

    public AdminPage()
    {
        anchorPane = new AnchorPane();
        scene = new Scene(anchorPane, 1280, 768);
        System.out.println("test");
        pointOfSaleBtn = new Button("Salg");
        StockManagementBtn = new Button("Lagerstyring");
        SalesHistoryBtn = new Button("Salgshistorik");
        backBtn = new BackButton();


        int yLayout = 50;
        int widthSize = 250;
        int heightSize = 40;
        int gap = 40;
        StockManagementBtn.setLayoutX((scene.getWidth() - widthSize) / 2);
        StockManagementBtn.setLayoutY(yLayout);
        StockManagementBtn.setPrefSize(widthSize, heightSize);
        StockManagementBtn.setOnAction(event ->
        {
            HelloApplication.changeScene(SceneName.InventoryManagement);
        });

        pointOfSaleBtn.setLayoutX(StockManagementBtn.getLayoutX() - (widthSize + gap));
        pointOfSaleBtn.setLayoutY(yLayout);
        pointOfSaleBtn.setPrefSize(widthSize, heightSize);
        // Mangler eventhandler

        SalesHistoryBtn.setLayoutX(StockManagementBtn.getLayoutX() + (widthSize + gap));
        SalesHistoryBtn.setLayoutY(yLayout);
        SalesHistoryBtn.setPrefSize(widthSize, heightSize);
        // Mangler eventhandler

        anchorPane.getChildren().addAll(pointOfSaleBtn, StockManagementBtn, SalesHistoryBtn, backBtn);
        String css = this.getClass().getResource("/com/example/canteensystem2/style.css").toExternalForm();
        scene.getStylesheets().add(css);
    }

    public Scene getScene()
    {
        return scene;
    }
}
