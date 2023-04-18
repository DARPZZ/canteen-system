package View;


import Helper.StockItemSupplierHelper;
import Model.DaOImplements.DaoStock;
import Model.StockItemSupplierData;
import com.example.canteensystem2.HelloApplication;
import com.example.canteensystem2.SceneName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class InventoryManagement extends AdminPage
{
    TableView<StockItemSupplierData> tableView;
    ObservableList<StockItemSupplierData> stockObservableList;
    TextField searchField;

    public InventoryManagement()
    {
        super.anchorPane.setOnMousePressed(event -> anchorPane.requestFocus());

        // Creates tableView
        stockObservableList = FXCollections.observableList(StockItemSupplierHelper.getData());
        tableView = new TableView<>(stockObservableList);
        tableView.setPrefSize((scene.getWidth() - 200), (scene.getHeight() - 300));
        tableView.setLayoutX((scene.getWidth() - tableView.getPrefWidth()) / 2);
        tableView.setLayoutY(250);
        tableView.setFocusTraversable(false);
        tableView.setEditable(true);
        createColumns();

        // Create a TextField for searching
        searchField = new TextField();
        searchField.setPrefSize(tableView.getPrefWidth(), 40);
        searchField.setLayoutX(tableView.getLayoutX());
        searchField.setLayoutY(tableView.getLayoutY() - searchField.getPrefHeight());
        searchField.setPromptText("\uD83D\uDD0E Søg");
        searchField.setStyle("-fx-font-size: 18");
        searchField.setFocusTraversable(false);

        Button backBtn = new BackButton();
        backBtn.setOnAction(event -> HelloApplication.changeScene(SceneName.AdminLogin));
        backBtn.setLayoutX(50);
        backBtn.setLayoutY(25);

        super.anchorPane.getChildren().addAll(tableView, searchField, backBtn);
    }

    public void searchFunction()
    {
        stockObservableList.clear();

        // Refill stockObservableList
    }

    public void createColumns()
    {
        int noColumn = 5;
        int xSize = (int) (tableView.getPrefWidth() / noColumn);

        TableColumn<StockItemSupplierData, Number> stockID = new TableColumn<>("Varenr.");
        stockID.setCellValueFactory(data -> data.getValue().getItemIdProperty());

        TableColumn<StockItemSupplierData, String> description = new TableColumn<>("Vare navn");
        description.setCellValueFactory(data -> data.getValue().getItemNameProperty());

        TableColumn<StockItemSupplierData, Number> currentLevel = new TableColumn<>("Stk. lager");
        currentLevel.setCellValueFactory(data -> data.getValue().getStockLevelProperty());

        TableColumn<StockItemSupplierData, Number> minLevel = new TableColumn<>("Min. lager");
        StringConverter<Number> converter = new NumberStringConverter();
        minLevel.setCellFactory(TextFieldTableCell.forTableColumn(converter));
        minLevel.setEditable(true);
        minLevel.setCellValueFactory(data -> data.getValue().getMinStockLevelProperty());

        minLevel.setOnEditCommit(table ->
        {
            table.getTableView().getItems().get(table.getTablePosition().getRow()).
                    setMinStockLevel(table.getNewValue().intValue());

            updateMinStock(table.getTableView().getItems().get(table.getTablePosition().getRow()));
        });

        TableColumn<StockItemSupplierData, Number> currentAndMin = new TableColumn<>("Lager mængde");
        currentAndMin.getColumns().add(currentLevel);
        currentAndMin.getColumns().add(minLevel);

        TableColumn<StockItemSupplierData, String> supplier = new TableColumn<>("Leverandør");
        supplier.setCellValueFactory(data -> data.getValue().getSupplierNameProperty());

        tableView.getColumns().add(stockID);
        tableView.getColumns().add(description);
        tableView.getColumns().add(currentAndMin);
        tableView.getColumns().add(supplier);

        for (TableColumn<StockItemSupplierData, ?> column : tableView.getColumns())
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

    public void updateMinStock(StockItemSupplierData stock)
    {
        new DaoStock().Update(stock.getItemId(), "fldMinStockLevel", String.valueOf(stock.getMinStockLevel()));
    }
}
