package Model.DaoObjects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Supplier
{
    private int SupplierID;
    private String Name;
    private IntegerProperty supplierIDProperty;
    private StringProperty nameProperty;

    public Supplier(int supplierID, String name) {
        SupplierID = supplierID;
        Name = name;

        supplierIDProperty = new SimpleIntegerProperty(supplierID);
        nameProperty = new SimpleStringProperty(name);
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int supplierID) {
        SupplierID = supplierID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public SimpleIntegerProperty getSupplierIDProperty()
    {
        SimpleIntegerProperty out = new SimpleIntegerProperty(SupplierID);
        return out;
    }


    public void setSupplierIDProperty(int supplierIDProperty)
    {
        this.supplierIDProperty.set(supplierIDProperty);
    }

    public SimpleStringProperty getNameProperty()
    {
        SimpleStringProperty out = new SimpleStringProperty(Name);
        return out;
    }
    public void setNameProperty(String nameProperty) {
        this.nameProperty.set(nameProperty);
    }
}
