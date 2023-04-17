package Model.DaoObjects;

import javafx.beans.property.*;

import java.time.LocalDate;

public class PurchaseOrder
{

    private IntegerProperty purchaseOrderID;
    private IntegerProperty supplierID;
    private IntegerProperty itemID;
    private IntegerProperty quantity;
    private FloatProperty purchasePrice;
    private StringProperty orderDate;

    public PurchaseOrder(int purchaseOrderID, int supplierID, int itemID, int quantity, float purchasePrice, LocalDate orderDate) {
        this.purchaseOrderID = new SimpleIntegerProperty(purchaseOrderID);
        this.supplierID = new SimpleIntegerProperty(supplierID);
        this.itemID = new SimpleIntegerProperty(itemID);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.purchasePrice = new SimpleFloatProperty(purchasePrice);
        this.orderDate = new SimpleStringProperty(orderDate.toString());

    }


    public int getPurchaseOrderID() {
        return purchaseOrderID.get();
    }

    public IntegerProperty getPurchaseOrderIDProperty() {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(int purchaseOrderID) {
        this.purchaseOrderID.set(purchaseOrderID);
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

    public int getItemID() {
        return itemID.get();
    }

    public IntegerProperty getItemIDProperty() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID.set(itemID);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty getQuantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public float getPurchasePrice() {
        return purchasePrice.get();
    }

    public FloatProperty getPurchasePriceProperty() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice.set(purchasePrice);
    }

    public String getOrderDate() {
        return orderDate.get();
    }

    public StringProperty getOrderDateProperty() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate.set(orderDate.toString());
    }
}
