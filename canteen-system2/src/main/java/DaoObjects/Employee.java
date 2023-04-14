package DaoObjects;

public class Employee
{
    private int EmployeeID;
    private String Name;
    private float Saldo;

    public Employee(int employeeID, String name, float saldo) {
        EmployeeID = employeeID;
        Name = name;
        Saldo = saldo;
    }
    public Employee(int employeeID, String name)
    {
        EmployeeID = employeeID;
        Name = name;
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
}
