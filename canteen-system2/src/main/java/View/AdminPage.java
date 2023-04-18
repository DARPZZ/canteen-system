package View;

import com.example.canteensystem2.HelloApplication;
import com.example.canteensystem2.PointOfSale;
import com.example.canteensystem2.SceneName;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public abstract class AdminPage
{
    public Scene scene;
    public AnchorPane anchorPane;
    public Button pointOfSaleBtn;
    public Button StockManagementBtn;
    public Button SalesHistoryBtn;
    public Button backBtn;

    public AdminPage()
    {
        anchorPane = new AnchorPane();
        scene = new Scene(anchorPane, 1280, 768);

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
        pointOfSaleBtn.setOnAction(event -> HelloApplication.changeScene(SceneName.PointOfSales));
        // Mangler eventhandler

        SalesHistoryBtn.setLayoutX(StockManagementBtn.getLayoutX() + (widthSize + gap));
        SalesHistoryBtn.setLayoutY(yLayout);
        SalesHistoryBtn.setPrefSize(widthSize, heightSize);
        // Mangler eventhandler


        anchorPane.getChildren().addAll(pointOfSaleBtn, StockManagementBtn, SalesHistoryBtn, backBtn);
    }

    public Scene getScene()
    {
        return scene;
    }
}
