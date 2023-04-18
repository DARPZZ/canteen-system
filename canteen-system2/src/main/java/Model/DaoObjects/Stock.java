package Model.DaoObjects;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Stock implements Comparable<Stock>
{

    private IntegerProperty stockID;
    private IntegerProperty itemID;
    private IntegerProperty stockLevel;
    private IntegerProperty minStockLevel;

    public Stock(int stockID,int itemID, int stockLevel, int minStockLevel)
    {
        this.stockID = new SimpleIntegerProperty(stockID);
        this.itemID = new SimpleIntegerProperty(itemID);
        this.stockLevel = new SimpleIntegerProperty(stockLevel);
        this.minStockLevel = new SimpleIntegerProperty(minStockLevel);
    }

    public Stock(int stockID, int itemID)
    {
        this.stockID = new SimpleIntegerProperty(stockID);
        this.itemID = new SimpleIntegerProperty(itemID);
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

    public IntegerProperty getStockIDProperty() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID.set(stockID);
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

    public int getStockLevel() {
        return stockLevel.get();
    }

    public IntegerProperty getStockLevelProperty() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel.set(stockLevel);
    }

    public int getMinStockLevel() {
        return minStockLevel.get();
    }

    public IntegerProperty getMinStockLevelProperty() {
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
