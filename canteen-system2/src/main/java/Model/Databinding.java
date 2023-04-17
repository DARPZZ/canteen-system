package Model;

import DaOImplements.*;
import DaoObjects.DaOInterface;
import DaoObjects.Employee;
import com.example.canteensystem2.Payment;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.FloatBinding;
import javafx.beans.property.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Databinding
{
    DaOInterface employee = new DaOEmployee();
    DaOInterface item = new DaOItem();
    DaOInterface purchaseorder = new DaOPurchaseOrder();
    DaOInterface stock = new DaoStock();
    DaOInterface supplier = new DaOSupplier();
    DaOInterface transaction = new DaOTransaction();
    private Stage s = new Stage();
    private TextField t = new TextField();


    public void bindEmployeeSaldo(int ID)
    {
        Employee emp = (Employee) employee.Get(ID);
        Payment p = new Payment(s,t);
       p.Saldo.textProperty().bind(emp.getSaldo().asString());
       /*
        p.Saldo.textProperty().bind(new FloatBinding()
        {
            {
                super.bind(emp.getSaldo());
            }
            @Override
            protected float computeValue() {
                float returnVal = 0.0f;
                try {
                    returnVal = (emp.getSaldo().getValue());
                }
                catch (Exception e){}

                return returnVal;
            }
        })

        */
    }
/*
    public EmployeeProperties findEmployeeIDProperty(int ID)
    {
         Employee emp = (Employee) employee.Get(ID);
         SimpleIntegerProperty employeeID = new SimpleIntegerProperty(emp.getEmployeeID());
         SimpleStringProperty employeeName = new SimpleStringProperty(emp.getName());
         SimpleFloatProperty employeeSaldo = new SimpleFloatProperty(emp.getSaldo());
         EmployeeProperties props = new EmployeeProperties(employeeID,employeeName,employeeSaldo);

         return props;

    }

 */


}
class EmployeeProperties
{
    private SimpleIntegerProperty employeeID;
    private SimpleStringProperty employeeName;
    private SimpleFloatProperty employeeSaldo;

    EmployeeProperties(SimpleIntegerProperty employeeID, SimpleStringProperty employeeName, SimpleFloatProperty employeeSaldo) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeSaldo = employeeSaldo;
    }

    public int getEmployeeID() {
        return employeeID.get();
    }

    public SimpleIntegerProperty employeeIDProperty() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName.get();
    }

    public SimpleStringProperty employeeNameProperty() {
        return employeeName;
    }

    public float getEmployeeSaldo() {
        return employeeSaldo.get();
    }

    public SimpleFloatProperty employeeSaldoProperty() {
        return employeeSaldo;
    }
}
