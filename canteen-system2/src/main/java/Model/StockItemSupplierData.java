package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StockItemSupplierData
{
    private IntegerProperty itemIdProperty;
    private StringProperty itemNameProperty;
    private IntegerProperty stockLevelProperty;
    private IntegerProperty minStockLevelProperty;
    private StringProperty supplierNameProperty;

    public StockItemSupplierData(int itemId, String itemName, int stockLevel, int minStockLevel, String supplierName)
    {
        this.itemIdProperty = new SimpleIntegerProperty(itemId);
        this.itemNameProperty = new SimpleStringProperty(itemName);
        this.stockLevelProperty = new SimpleIntegerProperty(stockLevel);
        this.minStockLevelProperty = new SimpleIntegerProperty(minStockLevel);
        this.supplierNameProperty = new SimpleStringProperty(supplierName);
    }

    //region getter/setter
    public int getItemIdProperty()
    {
        return itemIdProperty.get();
    }

    public IntegerProperty itemIdPropertyProperty()
    {
        return itemIdProperty;
    }

    public void setItemIdProperty(int itemIdProperty)
    {
        this.itemIdProperty.set(itemIdProperty);
    }

    public String getItemNameProperty()
    {
        return itemNameProperty.get();
    }

    public StringProperty itemNamePropertyProperty()
    {
        return itemNameProperty;
    }

    public void setItemNameProperty(String itemNameProperty)
    {
        this.itemNameProperty.set(itemNameProperty);
    }

    public int getStockLevelProperty()
    {
        return stockLevelProperty.get();
    }

    public IntegerProperty stockLevelPropertyProperty()
    {
        return stockLevelProperty;
    }

    public void setStockLevelProperty(int stockLevelProperty)
    {
        this.stockLevelProperty.set(stockLevelProperty);
    }

    public int getMinStockLevelProperty()
    {
        return minStockLevelProperty.get();
    }

    public IntegerProperty minStockLevelPropertyProperty()
    {
        return minStockLevelProperty;
    }

    public void setMinStockLevelProperty(int minStockLevelProperty)
    {
        this.minStockLevelProperty.set(minStockLevelProperty);
    }

    public String getSupplierNameProperty()
    {
        return supplierNameProperty.get();
    }

    public StringProperty supplierNamePropertyProperty()
    {
        return supplierNameProperty;
    }

    public void setSupplierNameProperty(String supplierNameProperty)
    {
        this.supplierNameProperty.set(supplierNameProperty);
    }
    //endregion
}
