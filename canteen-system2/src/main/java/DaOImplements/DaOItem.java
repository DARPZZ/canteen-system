package DaOImplements;

import DaoObjects.DaOInterface;
import DaoObjects.Employee;
import DaoObjects.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaOItem implements DaOInterface
{

    private static String userName = "sa";
    private static String password = "123456";
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
            preparedStatement = con.prepareStatement("INSERT INTO tblItem (fldName,fldPrice) VALUES (?,?)");

            preparedStatement.setString(1,item.getName());
            preparedStatement.setFloat(2,item.getPrice());
            preparedStatement.execute();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    @Override
    public void Remove(Object o, int ID)
    {
        item =(Item) o;
        try
        {
            preparedStatement = con.prepareStatement("DELETE FROM tblEmployee WHERE fldItemID = ?");
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

    @Override
    public void Get(int ID)
    {

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
