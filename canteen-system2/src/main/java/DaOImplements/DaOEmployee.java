package DaOImplements;


import DaoObjects.DaOInterface;
import DaoObjects.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:" + Port + ";databaseName=" + databaseName, userName, password);
        } catch (SQLException e) {
            System.err.println("Database connection fail" + e.getMessage());
        }
    }

    @Override
    public void Create(Employee employee)
    {
        try {
            preparedStatement = con.prepareStatement("INSERT INTO tblEmployee VALUES (?,?,?)");
            preparedStatement.setInt(1, employee.getEmployeeID());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setFloat(3, employee.getSaldo());
            preparedStatement.execute();
        } catch (Exception e) {
        }
    }

    @Override
    public void Remove(Employee employee, int ID)
    {
        try {
            preparedStatement = con.prepareStatement("DELETE FROM tblEmployee WHERE fldEmployeeID = ?");
            preparedStatement.setInt(1, ID);
            preparedStatement.execute();
        } catch (Exception e) {
        }
    }

    @Override
    public void Update(Employee employee, String fieldname, String value)
    {
        String sql ="UPDATE tblEmployee SET ";
               sql+= fieldname + " = '" + value+"'";
        sql+= " where fldEmployeeID = " + employee.getEmployeeID();
        System.out.println(sql);
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.executeQuery();
        } catch (Exception e) {
        }
    }
    @Override
    public void Delete(Employee employee, int ID)
    {
        try {
            preparedStatement = con.prepareStatement("DELETE FROM tblEmployee WHERE fldEmployeeID = ?");
            preparedStatement.setInt(1, ID);
            preparedStatement.execute();
        } catch (Exception e) {
        }
    }

    @Override
    public Employee Get(int ID)
    {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tblEmployee WHERE fldEmployeeID = ?");
            ps.setInt(1, ID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(rs.getInt("fldEmployeeID"));
                employee.setName(rs.getString("fldName"));
                employee.setSaldo(rs.getFloat("fldSaldo"));
                return employee;
            }
            return null; // no employee with the given id found in the database
        } catch (SQLException ex) {
            // handle any errors
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Employee> GetAll()
    {
        ArrayList<Employee> ARL = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from tblEmployee ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ARL.add(new Employee(rs.getInt("fldEmployeeID"), rs.getString("fldName"), rs.getString("fldPassword"), rs.getInt("fldSaldo")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ARL;
    }


}

