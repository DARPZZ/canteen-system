package View;

import Model.DaOImplements.DaOTransaction;
import Model.DaoObjects.Transaction;
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
        createColumn();

        super.anchorPane.getChildren().add(tableView);
    }

    /**
     * Creates the columns for the table
     */
    private void createColumn()
    {
        TableColumn<Transaction, Number> transactionId = new TableColumn<>("Salgs ID");
        transactionId.setCellValueFactory(data -> data.getValue().getTransactionIDProperty());

        TableColumn<Transaction, Number> customerId = new TableColumn<>("Kunde id");
        customerId.setCellValueFactory(data -> data.getValue().getEmployeeIDProperty());

        TableColumn<Transaction, Number> transactionAmount = new TableColumn<>("Total");
        transactionAmount.setCellValueFactory(data -> data.getValue().getTotalAmountProperty());

        TableColumn<Transaction, String> date = new TableColumn<>("Dato");
        date.setCellValueFactory(data -> data.getValue().getDateProperty());

        tableView.getColumns().add(transactionId);
        tableView.getColumns().add(customerId);
        tableView.getColumns().add(transactionAmount);
        tableView.getColumns().add(date);

        int noColumn = tableView.getColumns().size();
        int xSize = (int) (tableView.getPrefWidth() / noColumn);

        for (TableColumn<Transaction, ?> column : tableView.getColumns())
        {
            column.setReorderable(false);
            column.setResizable(false);
            column.setPrefWidth(xSize);
        }
    }
}
