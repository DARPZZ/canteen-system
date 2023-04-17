package Model.DaoObjects;

import javafx.beans.property.*;

public class Employee {
    private int employeeID;
    private String name;
    private String password;
    private float saldo;
    private IntegerProperty EmployeeIDProperty;
    private StringProperty NameProperty;
    private StringProperty passwordProperty;
    private FloatProperty SaldoProperty;

    public Employee(int empID, String n,String password, float s) {
        this.employeeID = empID;
        this.name = n;
        this.saldo = s;
        this.password = password;
        EmployeeIDProperty = new SimpleIntegerProperty(empID);
        NameProperty = new SimpleStringProperty(n);
        SaldoProperty = new SimpleFloatProperty(s);
        passwordProperty = new SimpleStringProperty(password);

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

    public String getPassword()
    {
        return passwordProperty.get();
    }

    public StringProperty passwordPropertyProperty()
    {
        return passwordProperty;
    }

    public void setPasswordProperty(String passwordProperty)
    {
        this.passwordProperty.set(passwordProperty);
    }
}