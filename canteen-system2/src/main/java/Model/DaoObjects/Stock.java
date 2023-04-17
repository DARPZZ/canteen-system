package Model.DaoObjects;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Stock implements Comparable<Stock>
{

    private IntegerProperty stockID;
    private IntegerProperty itemId;
    private IntegerProperty stockLevel;
    private IntegerProperty minStockLevel;

    public Stock(int stockID,int itemID, int stockLevel, int minStockLevel)
    {
        this.stockID = new SimpleIntegerProperty(stockID);
        this.itemId = new SimpleIntegerProperty(itemID);
        this.stockLevel = new SimpleIntegerProperty(stockLevel);
        this.minStockLevel = new SimpleIntegerProperty(minStockLevel);
    }

    public Stock(int stockID, int itemID)
    {
        this.stockID = new SimpleIntegerProperty(stockID);
        this.itemId = new SimpleIntegerProperty(itemID);
    }

    public Stock(int stockID, int stockLevel, int minStockLevel)
    {
        this.stockID = new SimpleIntegerProperty(stockID);
        this.stockLevel = new SimpleIntegerProperty(stockLevel);
        this.minStockLevel = new SimpleIntegerProperty(minStockLevel);
    }
//start region
    public int getStockID() {
        return stockID.get();
    }

    public IntegerProperty stockIDProperty() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID.set(stockID);
    }

    public int getItemId() {
        return itemId.get();
    }

    public IntegerProperty itemIdProperty() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId.set(itemId);
    }

    public int getStockLevel() {
        return stockLevel.get();
    }

    public IntegerProperty stockLevelProperty() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel.set(stockLevel);
    }

    public int getMinStockLevel() {
        return minStockLevel.get();
    }

    public IntegerProperty minStockLevelProperty() {
        return minStockLevel;
    }

    public void setMinStockLevel(int minStockLevel) {
        this.minStockLevel.set(minStockLevel);
    }

    //endregion


    @Override
    public int compareTo(Stock o)
    {
        if (this.stockID.get() > o.getStockID())
        {
            return 1;
        }
        else if (this.stockID.get() < o.getStockID())
        {
            return -1;
        }
        return 0;
    }
}
