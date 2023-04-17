package Model.DaoObjects;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Transaction
{
    private int TransActionID;
    private LocalDate Date;
    private float TotalAmount;
    private int EmployeeID;

    private IntegerProperty transactionIDProperty;
    private StringProperty dateProperty;
    private FloatProperty totalAmountProperty;
    private IntegerProperty employeeIDProperty;

    public Transaction(int transActionID, LocalDate date, float totalAmount, int employeeID) {
        TransActionID = transActionID;
        Date = date;
        TotalAmount = totalAmount;
        EmployeeID = employeeID;

        transactionIDProperty = new SimpleIntegerProperty(transActionID);
        dateProperty = new SimpleStringProperty(date.toString());
        totalAmountProperty = new SimpleFloatProperty(totalAmount);
        employeeIDProperty = new SimpleIntegerProperty(employeeID);
    }

    public int getTransActionID() {
        return TransActionID;
    }

    public void setTransActionID(int transActionID) {
        TransActionID = transActionID;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public float getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        TotalAmount = totalAmount;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }
}
