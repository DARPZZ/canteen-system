package Model.DaoObjects;

import javafx.beans.property.*;

public class Employee {
    private IntegerProperty employeeID;
    private StringProperty name;
    private FloatProperty saldo;

    public Employee(int empID, String n, float s) {
        employeeID = new SimpleIntegerProperty(empID);
        name = new SimpleStringProperty(n);
        saldo = new SimpleFloatProperty(s);
    }

    public Employee()
    {
    }

    public int getEmployeeID() {
        return employeeID.get();
    }

    public IntegerProperty employeeIDProperty() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID.set(employeeID);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public float getSaldo() {
        return saldo.get();
    }

    public FloatProperty saldoProperty() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo.set(saldo);
    }
}