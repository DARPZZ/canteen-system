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


    public SimpleIntegerProperty getPurchaseOrderIDProperty() {
        SimpleIntegerProperty out = new SimpleIntegerProperty(PurchaseOrderID);
        return out;
    }

    public void setPurchaseOrderIDProperty(int purchaseOrderIDProperty)
    {
        this.purchaseOrderIDProperty.set(purchaseOrderIDProperty);
    }



    public SimpleIntegerProperty getSupplierIDProperty() {
        SimpleIntegerProperty out = new SimpleIntegerProperty(SupplierID);
        return out;
    }

    public void setSupplierIDProperty(int supplierIDProperty) {
        this.supplierIDProperty.set(supplierIDProperty);
    }

    public SimpleIntegerProperty getItemIDProperty()
    {
        SimpleIntegerProperty out = new SimpleIntegerProperty(ItemID);
        return out;
    }

    public void setItemIDProperty(int itemIDProperty) {
        this.itemIDProperty.set(itemIDProperty);
    }

    public SimpleIntegerProperty getQuantityProperty()
    {
        SimpleIntegerProperty out = new SimpleIntegerProperty(Quantity);
        return out;
    }

    public void setQuantityProperty(int quantityProperty) {
        this.quantityProperty.set(quantityProperty);
    }

    public SimpleFloatProperty getPurchasePriceProperty()
    {
        SimpleFloatProperty out = new SimpleFloatProperty(PurchaseOrderID);
        return out;
    }

    public void setPurchasePriceProperty(float purchasePriceProperty) {
        this.purchasePriceProperty.set(purchasePriceProperty);
    }

    public SimpleStringProperty getOrderDateProperty()
    {
        SimpleStringProperty out = new SimpleStringProperty(OrderDate.toString());
        return out;
    }

    public void setOrderDateProperty(String orderDateProperty) {
        this.orderDateProperty.set(orderDateProperty);
    }
}
