package Model.DaOImplements;

import Model.DaoObjects.DaOInterface;
import Model.DaoObjects.Item;
import Model.DaoObjects.PurchaseOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaOPurchaseOrder implements DaOInterface<PurchaseOrder>
{

    private static String userName = "sa";
    private static String password = "123456";
    private static String databaseName = "dbCanteenSystem";
    private static String Port = "1433";
    private static Connection con;
    private PreparedStatement preparedStatement;
    public DaOPurchaseOrder()
    {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:"+Port+";databaseName="+databaseName,userName,password);
        } catch (SQLException e) {
            System.err.println("Database connection fail" + e.getMessage());
        }
    }

    @Override
    public void Create(PurchaseOrder o)
    {
        try {
            preparedStatement = con.prepareStatement("INSERT INTO tblPurchaseOrder VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1,o.getPurchaseOrderID());
            preparedStatement.setInt(2,o.getSupplierID());
            preparedStatement.setInt(3,o.getItemID());
            preparedStatement.setInt(4,o.getQuantity());
            preparedStatement.setFloat(5,o.getPurchasePrice());
            preparedStatement.setString(6, String.valueOf(o.getOrderDate()));
            preparedStatement.execute();
        }
        catch (Exception e)
        {}
    }

    @Override
    public void Update(PurchaseOrder o, String fieldname, String value)
    {
        try
        {
            preparedStatement = con.prepareStatement("UPDATE ? SET ? = ? WHERE tblPurchaseOrderID = ?");
            preparedStatement.setString(1,"tblItem");
            preparedStatement.setString(2,fieldname);
            switch (fieldname)
            {
                case "fldItemID":
                    preparedStatement.setInt(3,Integer.parseInt(value));
                    break;

                case "fldName":
                    preparedStatement.setString(3,value);
                    break;
                case "fldPrice":
                    preparedStatement.setFloat(3,Float.parseFloat(value));
            }
            preparedStatement.setInt(4,o.getPurchaseOrderID());
            preparedStatement.execute();
        }
        catch (Exception e)
        {}
    }
    @Override
    public void Delete(PurchaseOrder o, int ID)
    {
        try {
            preparedStatement = con.prepareStatement("DELETE FROM tblItem WHERE fldItemID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
        }
        catch (Exception e){}
    }

    @Override
    public PurchaseOrder Get(int ID)
    {
        try
        {
            preparedStatement = con.prepareStatement("SELECT * FROM tblItem WHERE fldPurchaseOrderID = ?");
            preparedStatement.setString(1, String.valueOf(ID));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                return new PurchaseOrder(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4),rs.getFloat(5),rs.getDate(6).toLocalDate());
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return null;
    }
    public List<PurchaseOrder> GetAll()
    {
        ArrayList<PurchaseOrder> ARL = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement("select * from tblPurchaseOrder");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            ARL.add(new PurchaseOrder(rs.getInt("fldPurchaseOrderID"),rs.getInt("fldSupplierID"),rs.getInt("fldItemID"),rs.getInt("fldQuantity"),rs.getFloat("fldPurchesPrice"), rs.getDate("fldOrderDate").toLocalDate()));
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return ARL;
    }



}
