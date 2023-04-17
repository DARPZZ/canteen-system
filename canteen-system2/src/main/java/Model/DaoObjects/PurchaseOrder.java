package Model.DaoObjects;

import javafx.beans.property.*;

import java.time.LocalDate;

public class PurchaseOrder
{
    private int PurchaseOrderID;
    private int SupplierID;
    private int ItemID;
    private int Quantity;
    private float PurchasePrice;
    private LocalDate OrderDate;

    private IntegerProperty purchaseOrderIDProperty;
    private IntegerProperty supplierIDProperty;
    private IntegerProperty itemIDProperty;
    private IntegerProperty quantityProperty;
    private FloatProperty purchasePriceProperty;
    private StringProperty orderDateProperty;

    public PurchaseOrder(int purchaseOrderID, int supplierID, int itemID, int quantity, float purchasePrice, LocalDate orderDate) {
        PurchaseOrderID = purchaseOrderID;
        SupplierID = supplierID;
        ItemID = itemID;
        Quantity = quantity;
        PurchasePrice = purchasePrice;
        OrderDate = orderDate;

        purchaseOrderIDProperty = new SimpleIntegerProperty(purchaseOrderID);
        supplierIDProperty = new SimpleIntegerProperty(supplierID);
        itemIDProperty = new SimpleIntegerProperty(itemID);
        quantityProperty = new SimpleIntegerProperty(quantity);
        purchasePriceProperty = new SimpleFloatProperty(purchasePrice);
        orderDateProperty = new SimpleStringProperty(orderDate.toString());


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

    public int getPurchaseOrderIDProperty() {
        return purchaseOrderIDProperty.get();
    }

    public IntegerProperty purchaseOrderIDPropertyProperty() {
        return purchaseOrderIDProperty;
    }

    public void setPurchaseOrderIDProperty(int purchaseOrderIDProperty) {
        this.purchaseOrderIDProperty.set(purchaseOrderIDProperty);
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

    public int getItemIDProperty() {
        return itemIDProperty.get();
    }

    public IntegerProperty itemIDPropertyProperty() {
        return itemIDProperty;
    }

    public void setItemIDProperty(int itemIDProperty) {
        this.itemIDProperty.set(itemIDProperty);
    }

    public int getQuantityProperty() {
        return quantityProperty.get();
    }

    public IntegerProperty quantityPropertyProperty() {
        return quantityProperty;
    }

    public void setQuantityProperty(int quantityProperty) {
        this.quantityProperty.set(quantityProperty);
    }

    public float getPurchasePriceProperty() {
        return purchasePriceProperty.get();
    }

    public FloatProperty purchasePricePropertyProperty() {
        return purchasePriceProperty;
    }

    public void setPurchasePriceProperty(float purchasePriceProperty) {
        this.purchasePriceProperty.set(purchasePriceProperty);
    }

    public String getOrderDateProperty() {
        return orderDateProperty.get();
    }

    public StringProperty orderDatePropertyProperty() {
        return orderDateProperty;
    }

    public void setOrderDateProperty(String orderDateProperty) {
        this.orderDateProperty.set(orderDateProperty);
    }
}
