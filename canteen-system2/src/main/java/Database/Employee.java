package Database;

public class Employee
{
    public int getEmployeeID()
    {
        return employeeID;
    }

    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public float getSaldo()
    {
        return saldo;
    }

    public void setSaldo(float saldo)
    {
        this.saldo = saldo;
    }

    public Employee(int employeeID, String name, float saldo)
    {
        this.employeeID = employeeID;
        Name = name;
        this.saldo = saldo;
    }

    private int employeeID;
    private String Name;
    private float saldo;
}
