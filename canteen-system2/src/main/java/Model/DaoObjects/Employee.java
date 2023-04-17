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

    public Employee()
    {
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

    public SimpleFloatProperty getSaldoProperty()
    {
        SimpleFloatProperty out = new SimpleFloatProperty(SaldoProperty.floatValue());
        return out;
    }

    public void setSaldoProperty(float saldoProperty) {
        this.SaldoProperty = new SimpleFloatProperty(saldoProperty);
    }

    public SimpleIntegerProperty getEmployeeIDProperty()
    {
        SimpleIntegerProperty out = new SimpleIntegerProperty(this.EmployeeIDProperty.get());
        return out;
    }


    public void setEmployeeIDProperty(int employeeIDProperty)
    {
        this.EmployeeIDProperty = new SimpleIntegerProperty(employeeIDProperty);
    }


    public SimpleStringProperty getNameProperty()
    {
        SimpleStringProperty out = new SimpleStringProperty(name);
        return out;
    }

    public void setNameProperty(String nameProperty)
    {

        this.NameProperty = new SimpleStringProperty(nameProperty);
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}