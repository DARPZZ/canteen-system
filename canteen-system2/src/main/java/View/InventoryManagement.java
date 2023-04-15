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
        description.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Stock, Number> currentLevel = new TableColumn<>("Stk. lager");
        currentLevel.setCellValueFactory(data -> data.getValue().getStockLevelProperty());

        TableColumn<Stock, Number> minLevel = new TableColumn<>("Min. lager");
        minLevel.setCellValueFactory(data -> data.getValue().getMinStockLevelProperty());

        TableColumn<Stock, Number> currentAndMin = new TableColumn<>("Lager mængde");
        currentAndMin.getColumns().addAll(currentLevel, minLevel);

        TableColumn<Stock, String> supplier = new TableColumn<>("Leverandør");
        //supplier.setCellValueFactory(data -> data.getValue().getDescriptionProperty());

        this.tableView.getColumns().setAll(stockID, description, currentAndMin, supplier);

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
