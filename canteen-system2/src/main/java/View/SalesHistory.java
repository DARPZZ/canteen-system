package View;


import DaOImplements.DaOTransaction;
import DaoObjects.Stock;
import DaoObjects.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SalesHistory extends AdminPage
{

    private TableView<Transaction> tableView;
    private ObservableList<Transaction> transactionsList;

    public SalesHistory()
    {
        transactionsList = FXCollections.observableList(new DaOTransaction().GetAll());
        tableView = new TableView<>(transactionsList);

        tableView.setPrefSize((scene.getWidth() - 200), (scene.getHeight() - 300));
        tableView.setLayoutX((scene.getWidth() - tableView.getPrefWidth()) / 2);
        tableView.setLayoutY(250);
        tableView.setFocusTraversable(false);
    }

    private void createColumn()
    {
        TableColumn<Transaction, Number> stockID = new TableColumn<>("Medarbejder Id");
        stockID.setCellValueFactory(data -> data.getValue().getEmployeeID());

        TableColumn<Stock, String> description = new TableColumn<>("Beskrivelse");
        //description.setCellValueFactory(data -> data.getValue().getDescriptionProperty());

        TableColumn<Stock, Number> currentLevel = new TableColumn<>("Stk. lager");
        currentLevel.setCellValueFactory(data -> data.getValue().getStockLevelProperty());
    }
}
