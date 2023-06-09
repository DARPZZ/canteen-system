package View;

import com.example.canteensystem2.HelloApplication;
import com.example.canteensystem2.SceneName;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public abstract class AdminPage
{
    public Scene scene;
    AnchorPane anchorPane;
    public Button pointOfSaleBtn;
    public Button InventoryManagementBtn;
    public Button SalesHistoryBtn;
    public Button backBtn;

    public AdminPage()
    {
        anchorPane = new AnchorPane();
        anchorPane.setOnMousePressed(event -> anchorPane.requestFocus());
        scene = new Scene(anchorPane, 1280, 768);


        pointOfSaleBtn = new Button("Salg");
        InventoryManagementBtn = new Button("Lagerstyring");
        SalesHistoryBtn = new Button("Salgshistorik");
        backBtn = new BackButton();
        pointOfSaleBtn.setId("loginButtons");
        InventoryManagementBtn.setId("loginButtons");
        SalesHistoryBtn.setId("loginButtons");

        backBtn.setOnAction(event -> HelloApplication.changeScene(SceneName.AdminLogin));


        int yLayout = 50;
        int widthSize = 250;
        int heightSize = 40;
        int gap = 40;
        InventoryManagementBtn.setLayoutX((scene.getWidth() - widthSize) / 2);
        InventoryManagementBtn.setLayoutY(yLayout);
        InventoryManagementBtn.setPrefSize(widthSize, heightSize);
        InventoryManagementBtn.setOnAction(event -> HelloApplication.changeScene(SceneName.InventoryManagement));

        pointOfSaleBtn.setLayoutX(InventoryManagementBtn.getLayoutX() - (widthSize + gap));
        pointOfSaleBtn.setLayoutY(yLayout);
        pointOfSaleBtn.setPrefSize(widthSize, heightSize);
        pointOfSaleBtn.setOnAction(event -> HelloApplication.changeScene(SceneName.PointOfSales));

        SalesHistoryBtn.setLayoutX(InventoryManagementBtn.getLayoutX() + (widthSize + gap));
        SalesHistoryBtn.setLayoutY(yLayout);
        SalesHistoryBtn.setPrefSize(widthSize, heightSize);
        SalesHistoryBtn.setOnAction(event -> HelloApplication.changeScene(SceneName.SalesHistory));

        String css = this.getClass().getResource("/com/example/canteensystem2/Style.css").toExternalForm();
        scene.getStylesheets().add(css);



        anchorPane.getChildren().addAll(pointOfSaleBtn, InventoryManagementBtn, SalesHistoryBtn, backBtn);

    }

    public Scene getScene()
    {
        return scene;
    }
}
