package View;

import DaOImplements.DaoStock;
import DaoObjects.Stock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class InventoryManagement
{

    Scene scene;
    AnchorPane anchorPane;
    TableView<Stock> tableView;
    ObservableList<Stock> stockObservableList;
    TextField searchField;

    public InventoryManagement()
    {
        anchorPane = new AnchorPane();
        anchorPane.setOnMousePressed(event -> anchorPane.requestFocus());
        scene = new Scene(anchorPane, 1280, 768);

        // Creates tableView
        List<Stock> stockList = getData();
        stockObservableList = FXCollections.observableList(stockList);
        tableView = new TableView<>(stockObservableList);
        tableView.setPrefSize((scene.getWidth() - 100), (scene.getHeight() - 200));
        tableView.setLayoutX((scene.getWidth() - tableView.getPrefWidth()) / 2);
        tableView.setLayoutY(150);
        tableView.setFocusTraversable(false);
        createColumns();

        // Create a TextField for searching
        searchField = new TextField();
        searchField.setPrefSize(tableView.getPrefWidth(), 40);
        searchField.setLayoutX(tableView.getLayoutX());
        searchField.setLayoutY(tableView.getLayoutY() - searchField.getPrefHeight());
        searchField.setPromptText("\uD83D\uDD0E Søg");
        searchField.setStyle("-fx-font-size: 18");
        searchField.setFocusTraversable(false);

        anchorPane.getChildren().addAll(tableView, searchField);
    }

    public void searchFunction()
    {
        stockObservableList.clear();

        // Refill stockObservableList
    }

    public List<Stock> getData()
    {
        return new DaoStock().GetAll();
    }

    public void createColumns()
    {
        int noColumn = 5;
        int xSize = (int) (this.tableView.getPrefWidth() / noColumn);

        TableColumn<Stock, Number> stockID = new TableColumn<>("Varenr.");
        stockID.setCellValueFactory(data -> data.getValue().getStockIdProperty());

        TableColumn<Stock, String> description = new TableColumn<>("Beskrivelse");
        //description.setCellValueFactory(data -> data.getValue().getDescriptionProperty());

        TableColumn<Stock, Number> currentLevel = new TableColumn<>("Stk. lager");
        currentLevel.setCellValueFactory(data -> data.getValue().getStockLevelProperty());

        TableColumn<Stock, Number> minLevel = new TableColumn<>("Min. lager");
        minLevel.setCellValueFactory(data -> data.getValue().getMinStockLevelProperty());

        TableColumn<Stock, Number> currentAndMin = new TableColumn<>("Lager mængde");
        //currentAndMin.getColumns().addAll(currentLevel, minLevel);
        currentAndMin.getColumns().add(currentLevel);
        currentAndMin.getColumns().add(minLevel);

        TableColumn<Stock, String> supplier = new TableColumn<>("Leverandør");
        //supplier.setCellValueFactory(data -> data.getValue().getSupplierNameProperty());

        //this.tableView.getColumns().setAll(stockID, description, currentAndMin, supplier);
        // This doesn't cause error but looks ugly
        this.tableView.getColumns().add(stockID);
        this.tableView.getColumns().add(description);
        this.tableView.getColumns().add(currentAndMin);
        this.tableView.getColumns().add(supplier);

        for (TableColumn<Stock, ?> column : tableView.getColumns())
        {
            column.setReorderable(false);
            column.setResizable(false);
            column.setPrefWidth(xSize);

            if (column.equals(currentAndMin))
            {
                for (int i = 0; i < column.getColumns().size(); i++)
                {
                    column.getColumns().get(i).setReorderable(false);
                    column.getColumns().get(i).setResizable(false);
                    column.getColumns().get(i).setPrefWidth(xSize);
                }
            }
        }
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
