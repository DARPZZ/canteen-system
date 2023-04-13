package Database;

import java.sql.*;
import java.util.ArrayList;



public class EmployeeImpl implements ProjectEmployee
{
    private static String userName = "sa";
    private static String password = "123456";
    private static String databaseName = "dbCanteenSystem";
    private static String Port = "1433";
    private static Connection con;
    public EmployeeImpl() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=dbCanteenSystem",userName,password);
        } catch (Exception e) {
            System.out.println("Failed to connect to the database:");
            e.printStackTrace();
        }
    }



    @Override
    public void addProject(Employee p)
    {
        try {

            System.out.println(con + "con");
            PreparedStatement ps = con.prepareStatement("INSERT INTO tblEmployee (fldEmployeeID, fldName, fldSaldo) VALUES (?, ?, ?)");

            ps.setInt(1, p.getEmployeeID());
            ps.setString(2, p.getName());
            ps.setFloat(3, p.getSaldo());

            ps.executeUpdate();

        }catch (Exception e)
        {
            System.out.println("tryyyyyyy" + e);
        }
    }
    @Override
    public void deleteProject(Employee p)
    {

    }

    @Override
    public void updateProject(Employee p)
    {

    }

    @Override
    public ArrayList<Employee> getAll() throws SQLException
    {
        return null;
    }



    @Override
    public Employee get(Employee p)
    {
        return null;
    }


}
