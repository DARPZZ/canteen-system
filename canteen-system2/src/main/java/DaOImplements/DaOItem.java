package DaOImplements;

import DaoObjects.DaOInterface;
import DaoObjects.Item;

import java.sql.*;

public class DaOItem implements DaOInterface
{

    private static String userName = "sa";
    private static String password = "1234";
    private static String databaseName = "dbCanteenSystem";
    private static String Port = "1433";
    private static Connection con;
    private PreparedStatement preparedStatement;

    Item item;
    public DaOItem()
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
        item =(Item) o;

        try {
            preparedStatement = con.prepareStatement("INSERT INTO tblItem VALUES (?,?,?)");
            preparedStatement.setInt(1,item.getItemID());
            preparedStatement.setString(2,item.getName());
            preparedStatement.setFloat(3,item.getPrice());
            preparedStatement.execute();
        }
        catch (Exception e)
        {}
    }
    @Override
    public void Remove(Object o, int ID)
    {
        item =(Item) o;
        try
        {
            preparedStatement = con.prepareStatement("DELETE FROM tlbItem WHERE fldItemID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
        }
        catch (Exception e)
        {}

    }
    @Override
    public void Update(Object o, String fieldname, String value)
    {
        item =(Item) o;
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
    public void Delete(Object o, int ID)
    {
        item =(Item) o;
        try {
            preparedStatement = con.prepareStatement("DELETE FROM tblItem WHERE fldItemID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
        }
        catch (Exception e){}
    }


}