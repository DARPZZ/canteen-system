package Model.DaOImplements;

import Model.DaoObjects.DaOInterface;
import Model.DaoObjects.Item;
import Model.DaoObjects.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaOTransaction implements DaOInterface
{

    private static String userName = "sa";
    private static String password = "123456";
    private static String databaseName = "dbCanteenSystem";
    private static String Port = "1433";
    private static Connection con;
    private PreparedStatement preparedStatement;

    Transaction transaction;
    public DaOTransaction()
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
        transaction =(Transaction) o;

        try {
            preparedStatement = con.prepareStatement("INSERT INTO tblTransaction (fldDate,fldTotalAmount,fldEmployeeID) VALUES (?,?,?)");

            //preparedStatement.setInt(1,transaction.getTransactionID());
            Date temp = Date.valueOf(transaction.getDate());
            preparedStatement.setDate(1,temp);
            preparedStatement.setFloat(2,transaction.getTotalAmount());
            preparedStatement.setInt(3,transaction.getEmployeeID());
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
        transaction =(Transaction) o;
        try
        {
            preparedStatement = con.prepareStatement("UPDATE ? SET ? = ? WHERE fldTransactionID = ?");
            preparedStatement.setString(1,"tblTransaction");
            preparedStatement.setString(2,fieldname);
            preparedStatement.setInt(3,Integer.parseInt(value));
            preparedStatement.setInt(4,transaction.getTransactionID());
            preparedStatement.execute();
        }
        catch (Exception e)
        {}
    }
    @Override
    public void Delete(Object o, int ID)
    {
        transaction =(Transaction) o;
        try {
            preparedStatement = con.prepareStatement("DELETE FROM tblTransaction WHERE fldTransActionID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
        }
        catch (Exception e){}
    }

    @Override
    public Transaction Get(int ID)
    {
        try
        {
            preparedStatement = con.prepareStatement("SELECT * FROM tblItem WHERE fldTransactionID = ?");
            preparedStatement.setString(1, String.valueOf(ID));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                return new Transaction(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getFloat(3),rs.getInt(4));
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return null;

    }
    public int getLatestID()
    {
        try {
            preparedStatement = con.prepareStatement("SELECT TOP(1) fldTransactionID FROM tblTransaction");
            ResultSet rs = preparedStatement.executeQuery();
            return rs.getInt(1);
        }catch (Exception e){}
        return 0;
    }
    @Override
    public List<Transaction> GetAll()
    {
        ArrayList<Transaction> ARL = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement("select * from tblTransaction ");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ARL.add(new Transaction(rs.getInt("fldTransActionID"),rs.getDate("fldDate").toLocalDate() ,rs.getFloat("fldTotalAmount"),rs.getInt("fldEmployeeID")));
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return ARL;
    }


}
