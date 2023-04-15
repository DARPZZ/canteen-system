package View;


import DaOImplements.DaoStock;
import DaoObjects.Stock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class InventoryManagement
{

    Scene scene;
    AnchorPane anchorPane;
    TableView<Stock> tableView;
    ObservableList<Stock> stockObservableList;

    public InventoryManagement()
    {
        anchorPane = new AnchorPane();
        scene = new Scene(anchorPane, 1280, 768);

        // Creates tableView
        List<Stock> stockList = getData();
        stockObservableList = FXCollections.observableList(stockList);

        tableView = new TableView<>(stockObservableList);
        tableView.setPrefSize((scene.getWidth() - 100), (scene.getHeight() - 200));
        tableView.setLayoutX((scene.getWidth() - tableView.getPrefWidth()) / 2);
        tableView.setLayoutY(150);

        createColumns();
        anchorPane.getChildren().add(tableView);
    }

    public void searchFunction()
    {

    }

    public List<Stock> getData()
    {
        DaoStock data = new DaoStock();

        return data.GetAll();
    }

    public void createColumns()
    {
        int xSize = (int) (this.tableView.getPrefWidth() / 4.0);

        TableColumn<Stock, Number> stockID = new TableColumn<>("Varenr.");
        stockID.setCellValueFactory(new PropertyValueFactory<>("StockIdProperty"));
        stockID.setCellValueFactory(data -> data.getValue().getStockIdProperty());
        stockID.setPrefWidth(xSize);

        TableColumn<Stock, String> description = new TableColumn<>("Beskrivelse");
        //description.setCellValueFactory(new PropertyValueFactory<>("description"));
        description.setPrefWidth(xSize);

        TableColumn<Stock, Number> currentLevel = new TableColumn<>("Stk. lager");
        currentLevel.setCellValueFactory(data -> data.getValue().getStockLevelProperty());
        currentLevel.setPrefWidth(xSize);

        TableColumn<Stock, Number> minLevel = new TableColumn<>("Min. lager");
        minLevel.setCellValueFactory(data -> data.getValue().getMinStockLevelProperty());
        minLevel.setPrefWidth(xSize);

        TableColumn<Stock, Number> currentAndMin = new TableColumn<>("Lager mængde");
        currentAndMin.getColumns().addAll(currentLevel, minLevel);
        currentAndMin.setPrefWidth(xSize);

        this.tableView.getColumns().setAll(stockID, description, currentAndMin);
    }

    public void addToTable(Stock stock)
    {
        stockObservableList.add(stock);
    }


    public Scene getScene()
    {
        return scene;
    }
}
