package DaOImplements;

import DaoObjects.DaOInterface;
import DaoObjects.Employee;
import DaoObjects.PurchaseOrder;

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

    PurchaseOrder purchaseOrder;
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
        purchaseOrder =(PurchaseOrder) o;

        try {
            preparedStatement = con.prepareStatement("INSERT INTO tblPurchaseOrder VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1,purchaseOrder.getPurchaseOrderID());
            preparedStatement.setInt(2,purchaseOrder.getSupplierID());
            preparedStatement.setInt(3,purchaseOrder.getItemID());
            preparedStatement.setInt(4,purchaseOrder.getQuantity());
            preparedStatement.setFloat(5,purchaseOrder.getPurchasePrice());
            preparedStatement.setString(6, String.valueOf(purchaseOrder.getOrderDate()));
            preparedStatement.execute();
        }
        catch (Exception e)
        {}
    }
    @Override
    public void Remove(PurchaseOrder o, int ID)
    {
        purchaseOrder =(PurchaseOrder) o;
        try
        {
            preparedStatement = con.prepareStatement("DELETE FROM tblPurchaseOrder WHERE fldPurchaseOrderID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
        }
        catch (Exception e)
        {}

    }
    @Override
    public void Update(PurchaseOrder o, String fieldname, String value)
    {
        purchaseOrder =(PurchaseOrder) o;
        try
        {
            preparedStatement = con.prepareStatement("UPDATE ? SET ? = ?");
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
            preparedStatement.execute();
        }
        catch (Exception e)
        {}
    }
    @Override
    public void Delete(PurchaseOrder o, int ID)
    {
        purchaseOrder =(PurchaseOrder) o;
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
        PurchaseOrder order = null;
        try
        {
            preparedStatement = con.prepareStatement("SELECT * FROM tblPurchaseOrder WHERE fldPurchaseOrderID = ?");
            preparedStatement.setInt(1,ID);
            ResultSet rs = preparedStatement.executeQuery();
            order = new PurchaseOrder(rs.getInt("fldPurchaseOrderID"),rs.getInt("fldSupplierID"),rs.getInt("fldItemID"),rs.getInt("fldQuantity"),rs.getFloat("fldPurchesPrice"), rs.getDate("fldOrderDate").toLocalDate());


        } catch (Exception e){}
        return order;
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
