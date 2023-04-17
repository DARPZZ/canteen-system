package Model.DaoObjects;

import javafx.beans.property.*;

public class Employee {
    private int employeeID;
    private String name;
    private float saldo;
    private IntegerProperty EmployeeIDProperty;
    private StringProperty NameProperty;
    private FloatProperty SaldoProperty;

    public Employee(int empID, String n, float s) {
        this.employeeID = empID;
        this.name = n;
        this.saldo = s;
        EmployeeIDProperty = new SimpleIntegerProperty(empID);
        NameProperty = new SimpleStringProperty(n);
        SaldoProperty = new SimpleFloatProperty(s);
    }

    public Employee() {
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FloatProperty getSaldoProperty() {
        return SaldoProperty;
    }

    public void setSaldoProperty(float saldoProperty) {
        this.saldo = saldoProperty;
    }

    public int getEmployeeIDProperty() {
        return EmployeeIDProperty.get();
    }

    public IntegerProperty employeeIDPropertyProperty() {
        return EmployeeIDProperty;
    }

    public void setEmployeeIDProperty(int employeeIDProperty) {
        this.EmployeeIDProperty.set(employeeIDProperty);
    }

    public String getNameProperty() {
        return NameProperty.get();
    }

    public StringProperty namePropertyProperty() {
        return NameProperty;
    }

    public void setNameProperty(String nameProperty) {
        this.NameProperty.set(nameProperty);
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}