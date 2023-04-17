package Model.DaOImplements;

import Model.DaoObjects.DaOInterface;
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
            preparedStatement = con.prepareStatement("INSERT INTO tblTransaction (fldTransActionID,fldDate,fldTotalAmount,fldEmployeeID) VALUES (?,?,?,?)");

            preparedStatement.setInt(1,transaction.getTransactionID());
            Date temp = Date.valueOf(transaction.getDate());
            preparedStatement.setDate(2,temp);
            preparedStatement.setFloat(3,transaction.getTotalAmount());
            preparedStatement.setInt(4,transaction.getEmployeeID());
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
        Transaction tempTransaction = null;
        try
        {
            preparedStatement = con.prepareStatement("SELECT * FROM tblTransaction WHERE fldTransActionID = ?");
            preparedStatement.setInt(1,ID);
            ResultSet rs = preparedStatement.executeQuery();
            tempTransaction = new Transaction(rs.getInt("fldTransActionID"),rs.getDate("fldDate").toLocalDate() ,rs.getFloat("fldTotalAmount"),rs.getInt("fldEmployeeID"));
        } catch (Exception e){}
        return tempTransaction;

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
