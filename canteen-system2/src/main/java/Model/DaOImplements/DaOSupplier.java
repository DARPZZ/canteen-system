package Model.DaOImplements;

import Model.DaoObjects.DaOInterface;
import Model.DaoObjects.Item;
import Model.DaoObjects.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaOSupplier implements DaOInterface
{

    private static String userName = "sa";
    private static String password = "123456";
    private static String databaseName = "dbCanteenSystem";
    private static String Port = "1433";
    private static Connection con;
    private PreparedStatement preparedStatement;

    Supplier supplier;
    public DaOSupplier()
    {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:"+Port+";databaseName="+databaseName,userName,password);
        } catch (SQLException e) {
            System.err.println("Database connection fail" + e.getMessage());
        }
    }

    @Override
    public void Create(Object o)
    {
        supplier =(Supplier) o;

        try {
            preparedStatement = con.prepareStatement("INSERT INTO tblSupplier (fldSupplierID,fldName) VALUES (?,?)");

            preparedStatement.setInt(1,supplier.getSupplierID());
            preparedStatement.setString(2,supplier.getName());

            preparedStatement.execute();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    @Override
    public void Update(Object o, String fieldname, String value)
    {
        supplier =(Supplier) o;
        try
        {
            preparedStatement = con.prepareStatement("UPDATE ? SET ? = ? WHERE fldSupplierID = ?");
            preparedStatement.setString(1,"tblSupplier");
            preparedStatement.setString(2,fieldname);
            preparedStatement.setInt(3,Integer.parseInt(value));
            preparedStatement.setInt(4,supplier.getSupplierID());
            preparedStatement.execute();
        }
        catch (Exception e)
        {}
    }
    @Override
    public void Delete(Object o, int ID)
    {
        supplier =(Supplier) o;
        try {
            preparedStatement = con.prepareStatement("DELETE FROM tblSupplier WHERE fldSupplierID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
        }
        catch (Exception e){}
    }

    @Override
    public Supplier Get(int ID)
    {
        try
        {
            preparedStatement = con.prepareStatement("SELECT * FROM tblItem WHERE fldSupplierID = ?");
            preparedStatement.setString(1, String.valueOf(ID));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                return new Supplier(rs.getInt(1), rs.getString(2));
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return null;

    }
    @Override
    public List<Supplier> GetAll()
    {
        ArrayList<Supplier> ARL = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement("select * from tblSupplier ");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ARL.add(new Supplier(rs.getInt(rs.getInt("fldSupplierID")), rs.getString("fldName")));
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return ARL;
    }


}
