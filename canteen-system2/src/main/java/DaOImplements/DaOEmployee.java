package DaOImplements;


import DaoObjects.DaOInterface;
import DaoObjects.Employee;
import java.sql.*;


public class DaOEmployee implements DaOInterface<Employee>
{

    private static String userName = "sa";
    private static String password = "123456";
    private static String databaseName = "dbCanteenSystem";
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

    @Override
    public void Create(Employee employee)
    {
        try {
            preparedStatement = con.prepareStatement("INSERT INTO tblEmployee VALUES (?,?,?)");
            preparedStatement.setInt(1,employee.getEmployeeID());
            preparedStatement.setString(2,employee.getName());
            preparedStatement.setFloat(3,employee.getSaldo());
            preparedStatement.execute();
        }
        catch (Exception e)
        {}
    }
    @Override
    public void Remove(Employee employee, int ID)
    {
        try
        {
            preparedStatement = con.prepareStatement("DELETE FROM tblEmployee WHERE fldEmployeeID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
        }
        catch (Exception e)
        {}

    }
    @Override
    public void Update(Employee employee, String fieldname, String value)
    {
        try
        {
            preparedStatement = con.prepareStatement("UPDATE ? SET ? = ?");
            preparedStatement.setString(1,"tblEmployee");
            preparedStatement.setString(2,fieldname);
                switch (fieldname)
            {
                    case "fldEmployeeID":
                        preparedStatement.setInt(3,Integer.parseInt(value));
                        break;

                    case "fldName":
                        preparedStatement.setString(3,value);
                        break;
                    case "fldSaldo":
                        preparedStatement.setInt(3,Integer.parseInt(value));
        }
        preparedStatement.execute();
        }
        catch (Exception e)
        {}
    }
    @Override
    public void Delete(Employee employee, int ID)
    {
        try {
            preparedStatement = con.prepareStatement("DELETE FROM tblEmployee WHERE fldEmployeeID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
        }
        catch (Exception e){}
    }

}