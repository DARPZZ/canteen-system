package Model.DaoObjects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Supplier
{
    private IntegerProperty supplierID;
    private StringProperty name;

    public Supplier(int supplierID, String name) {
        this.supplierID = new SimpleIntegerProperty(supplierID);
        this.name = new SimpleStringProperty(name);
    }

    public int getSupplierID() {
        return supplierID.get();
    }

    public IntegerProperty getSupplierIDProperty() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID.set(supplierID);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
