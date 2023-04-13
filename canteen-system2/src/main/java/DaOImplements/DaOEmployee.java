package DaOImplements;


import DaoObjects.DaOInterface;
import DaoObjects.Employee;
import java.sql.*;


public class DaOEmployee implements DaOInterface<Employee>
{

    private static String userName = "sa";
    private static String password = "123456";
    private static String databaseName = "sample";
    private static String Port = "1433";
    private static Connection con;
    private PreparedStatement preparedStatement;

    public DaOEmployee()
    {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:"+Port+";databaseName="+databaseName,userName,password);
        } catch (SQLException e) {
            System.err.println("Database connection fail" + e.getMessage());
        }
    }

    public void Create(Employee employee)
    {
        preparedStatement.


    }
    public void Remove(Employee employee)
    {}
    public void Update(Employee employee)
    {}
    public void Delete(Employee employee)
    {}

}
