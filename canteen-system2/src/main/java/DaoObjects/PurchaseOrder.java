package DaoObjects;

import java.time.LocalDate;

public class PurchaseOrder
{
    private int PurchaseOrderID;
    private int SupplierID;
    private int ItemID;
    private int Quantity;
    private float PurchasePrice;
    private LocalDate OrderDate;

    public PurchaseOrder(int purchaseOrderID, int supplierID, int itemID, int quantity, float purchasePrice, LocalDate orderDate) {
        PurchaseOrderID = purchaseOrderID;
        SupplierID = supplierID;
        ItemID = itemID;
        Quantity = quantity;
        PurchasePrice = purchasePrice;
        OrderDate = orderDate;
    }

    public int getPurchaseOrderID() {
        return PurchaseOrderID;
    }

    public void setPurchaseOrderID(int purchaseOrderID) {
        PurchaseOrderID = purchaseOrderID;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int supplierID) {
        SupplierID = supplierID;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public float getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public LocalDate getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        OrderDate = orderDate;
    }
}
