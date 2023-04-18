package Model.DaoObjects;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Transaction
{
    private IntegerProperty transactionID;
    private StringProperty date;
    private FloatProperty totalAmount;
    private IntegerProperty employeeID;

    public Transaction(int transActionID, LocalDate date, float totalAmount, int employeeID) {

        transactionID = new SimpleIntegerProperty(transActionID);
        this.date = new SimpleStringProperty(date.toString());
        this.totalAmount = new SimpleFloatProperty(totalAmount);
        this.employeeID = new SimpleIntegerProperty(employeeID);
    }

    public int getTransactionID() {
        return transactionID.get();
    }

    public IntegerProperty getTransactionIDProperty() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID.set(transactionID);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty getDateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public float getTotalAmount() {
        return totalAmount.get();
    }

    public FloatProperty getTotalAmountProperty() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount.set(totalAmount);
    }

    public int getEmployeeID() {
        return employeeID.get();
    }

    public IntegerProperty getEmployeeIDProperty() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID.set(employeeID);
    }
}
