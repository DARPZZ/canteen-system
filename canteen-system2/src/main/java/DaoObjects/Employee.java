package DaoObjects;

import javafx.beans.property.*;

public class Employee
{
    private IntegerProperty EmployeeID;
    private StringProperty Name;
    private FloatProperty Saldo;

    public Employee(int employeeID, String name, float saldo) {
        EmployeeID.setValue(employeeID);
        Name.setValue(name);
        Saldo.setValue(saldo);
    }

    public Employee()
    {

    }

    public IntegerProperty getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = new SimpleIntegerProperty(employeeID);
    }

    public StringProperty getName() {
        return Name;
    }

    public void setName(String name) {
        Name = new SimpleStringProperty(name);
    }

    public FloatProperty getSaldo() {
        return Saldo;
    }

    public void setSaldo(float saldo) {
        Saldo = new SimpleFloatProperty(saldo);
    }
}
