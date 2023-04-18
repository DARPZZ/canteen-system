package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StockItemSupplier
{
    private IntegerProperty itemId;
    private StringProperty itemName;
    private IntegerProperty stockLevel;
    private IntegerProperty minStockLevel;
    private StringProperty supplierName;

    public StockItemSupplier(int itemId, String itemName, int stockLevel, int minStockLevel, String supplierName)
    {
        this.itemId = new SimpleIntegerProperty(itemId);
        this.itemName = new SimpleStringProperty(itemName);
        this.stockLevel = new SimpleIntegerProperty(stockLevel);
        this.minStockLevel = new SimpleIntegerProperty(minStockLevel);
        this.supplierName = new SimpleStringProperty(supplierName);
    }

    public StockItemSupplier(int itemId, int stockLevel, int minStockLevel)
    {
        this.itemId = new SimpleIntegerProperty(itemId);
        this.stockLevel = new SimpleIntegerProperty(stockLevel);
        this.minStockLevel = new SimpleIntegerProperty(minStockLevel);
    }

    public StockItemSupplier()
    {

    }

    //region getter/setter
    public int getItemId()
    {
        return itemId.get();
    }

    public IntegerProperty getItemIdProperty()
    {
        return itemId;
    }

    public void setItemId(int itemId)
    {
        this.itemId.set(itemId);
    }

    public String getItemName()
    {
        return itemName.get();
    }

    public StringProperty getItemNameProperty()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName.set(itemName);
    }

    public int getStockLevel()
    {
        return stockLevel.get();
    }

    public IntegerProperty getStockLevelProperty()
    {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel)
    {
        this.stockLevel.set(stockLevel);
    }

    public int getMinStockLevel()
    {
        return minStockLevel.get();
    }

    public IntegerProperty getMinStockLevelProperty()
    {
        return minStockLevel;
    }

    public void setMinStockLevel(int minStockLevel)
    {
        this.minStockLevel.set(minStockLevel);
    }

    public String getSupplierName()
    {
        return supplierName.get();
    }

    public StringProperty getSupplierNameProperty()
    {
        return supplierName;
    }

    public void setSupplierName(String supplierName)
    {
        this.supplierName.set(supplierName);
    }
    //endregion
}
