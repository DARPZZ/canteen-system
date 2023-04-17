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

    public int getSupplierIDProperty() {
        return supplierIDProperty.get();
    }

    public IntegerProperty supplierIDPropertyProperty() {
        return supplierIDProperty;
    }

    public void setSupplierIDProperty(int supplierIDProperty) {
        this.supplierIDProperty.set(supplierIDProperty);
    }

    public String getNameProperty() {
        return nameProperty.get();
    }

    public StringProperty namePropertyProperty() {
        return nameProperty;
    }

    public void setNameProperty(String nameProperty) {
        this.nameProperty.set(nameProperty);
    }
}
