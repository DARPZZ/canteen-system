package DaoObjects;

public class Supplier
{
    private int SupplierID;
    private String Name;

    public Supplier(int supplierID, String name) {
        SupplierID = supplierID;
        Name = name;
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
}
