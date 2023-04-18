package Model.DaOImplements;

import Model.DaoObjects.DaOInterface;
import Model.DaoObjects.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaOItem implements DaOInterface<Item>
{

    private static String userName = "sa";
    private static String password = "123456";
    private static String databaseName = "dbCanteenSystem";
    private static String Port = "1433";
    private static Connection con;
    private PreparedStatement preparedStatement;
    public DaOItem()
    {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:"+Port+";databaseName="+databaseName,userName,password);
        } catch (SQLException e) {
            System.err.println("Database connection fail" + e.getMessage());
        }
    }

    @Override
    public void Create(Item o)
    {

        try {
            preparedStatement = con.prepareStatement("INSERT INTO tblItem (fldName,fldPrice) VALUES (?,?)");

            preparedStatement.setString(1,o.getName());
            preparedStatement.setFloat(2,o.getPrice());
            preparedStatement.execute();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void Update(Item o, String fieldname, String value)
    {
        try
        {
            preparedStatement = con.prepareStatement("UPDATE ? SET ? = ? WHERE tblItemID = ?");
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
            preparedStatement.setInt(4,o.getItemID());
            preparedStatement.execute();
        }
        catch (Exception e)
        {}
    }
    @Override
    public void Delete(Item o, int ID)
    {
        try {
            preparedStatement = con.prepareStatement("DELETE FROM tblItem WHERE fldItemID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
        }
        catch (Exception e){}
    }
/*
    @Override
    public Item Get(int ID)
    {
        Item tempItem = null;
        try
        {
            preparedStatement = con.prepareStatement("SELECT * FROM tblItem WHERE fldItemID = ?");
            preparedStatement.setInt(1,ID);
            ResultSet rs = preparedStatement.executeQuery();
            tempItem = new Item(rs.getInt("fldItemID"), rs.getString("fldName"),rs.getFloat("fldPrice"));

        } catch (Exception e){}
        return tempItem;
    }

 */

    @Override
    public Item Get(int ID)
    {
        try
        {
            preparedStatement = con.prepareStatement("SELECT * FROM tblItem WHERE fldItemID = ?");
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next())
            {
                return new Item(rs.getInt(1), rs.getString(2), (rs.getFloat(3)));
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return null;
    }
@Override
    public List<Item> GetAll()
    {
        ArrayList<Item> ARL = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from tblItem ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ARL.add(new Item(rs.getInt("fldItemID"), rs.getString("fldName"),rs.getFloat("fldPrice")));
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return ARL;
    }


}
