package Model.DaOImplements;

import Model.DaoObjects.DaOInterface;
import Model.DaoObjects.Item;
import Model.DaoObjects.Stock;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoStock implements DaOInterface<Stock>
{

    private static String userName = "sa";
    private static String password = "123456";
    private static String databaseName = "dbCanteenSystem";
    private static String Port = "1433";
    private static Connection con;
    private PreparedStatement preparedStatement;

    public DaoStock()
    {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:"+Port+";databaseName="+databaseName,userName,password);
        } catch (SQLException e) {
            System.err.println("Database connection fail" + e.getMessage());
        }
    }

    @Override
    public void Create(Stock o)
    {
        try {
            preparedStatement = con.prepareStatement("INSERT INTO tblStock (fldStockID,fldItemID,fldStockLevel,fldMibStockLevel) VALUES (?,?,?,?)");

            preparedStatement.setInt(1,o.getStockID());
            preparedStatement.setInt(2,o.getItemID());
                preparedStatement.setInt(3,o.getStockLevel());
            preparedStatement.setInt(4,o.getMinStockLevel());
            preparedStatement.execute();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void Update(Stock o, String fieldname, String value)
    {
        String sql ="UPDATE tblStock SET ";
        sql+= fieldname + " = '" + value+"'";
        sql+= " where fldStockID = " + o.getStockID();
        System.out.println(sql);
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.executeQuery();
        } catch (Exception e) {
        }
        {}
    }
    @Override
    public void Delete(Stock o, int ID)
    {
        try {
            preparedStatement = con.prepareStatement("DELETE FROM tblStock WHERE fldStockID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
        }
        catch (Exception e){}
    }

    @Override
    public Stock Get(int ID)
    {
        try
        {
            preparedStatement = con.prepareStatement("SELECT * FROM tblItem WHERE fldItemID = ?");
            preparedStatement.setString(1, String.valueOf(ID));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                return new Stock(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return null;

    }
    @Override
    public List<Stock> GetAll()
    {
        ArrayList<Stock> ARL = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement("select * from tblStock ");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                ARL.add(new Stock(rs.getInt("fldStockID"), rs.getInt("fldItemID"), rs.getInt("fldStockLevel"), rs.getInt("fldMinStockLevel")));
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return ARL;
    }


}
