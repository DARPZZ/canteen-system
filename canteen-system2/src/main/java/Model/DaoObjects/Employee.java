package Model.DaoObjects;

import javafx.beans.property.*;

public class Employee
{
    private int EmployeeID;
    private String Name;
    private String password;
    private float Saldo;

    public Employee(int employeeID, String name, String password, float saldo) {
        EmployeeID = employeeID;
        Name = name;
        Saldo = saldo;
        this.password = password;
    }

    public Employee()
    {

    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float saldo) {
        Saldo = saldo;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}