package DaoObjects;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Stock implements Comparable<Stock>
{
    private int StockID;
    private int ItemID;
    private int StockLevel;
    private int MinStockLevel;

    private IntegerProperty stockIdProperty;
    private IntegerProperty itemIdProperty;
    private IntegerProperty stockLevelProperty;
    private IntegerProperty minStockLevelProperty;

    public Stock(int stockID,int itemID, int stockLevel, int minStockLevel)
    {
        this.StockID = stockID;
        this.ItemID = itemID;
        this.StockLevel = stockLevel;
        this.MinStockLevel = minStockLevel;

        this.stockIdProperty = new SimpleIntegerProperty(stockID);
        this.itemIdProperty = new SimpleIntegerProperty(itemID);
        this.stockLevelProperty = new SimpleIntegerProperty(stockLevel);
        this.minStockLevelProperty = new SimpleIntegerProperty(minStockLevel);
    }

    public Stock(int stockID, int itemID)
    {
        this.StockID = stockID;
        this.ItemID = itemID;
    }

    public Stock(int stockID, int stockLevel, int minStockLevel)
    {
        StockID = stockID;
        StockLevel = stockLevel;
        MinStockLevel = minStockLevel;
    }

    public int getStockID() {
        return StockID;
    }

    public void setStockID(int stockID) {
        StockID = stockID;
        stockIdProperty.set(stockID);
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
        itemIdProperty.set(itemID);
    }

    public int getStockLevel() {
        return StockLevel;
    }

    public void setStockLevel(int stockLevel) {
        StockLevel = stockLevel;
        stockLevelProperty.set(stockLevel);
    }

    public int getMinStockLevel() {
        return MinStockLevel;
    }

    public void setMinStockLevel(int minStockLevel) {
        MinStockLevel = minStockLevel;
        minStockLevelProperty.set(minStockLevel);
    }

    //region property getter

    public IntegerProperty getStockIdProperty()
    {
        return stockIdProperty;
    }

    public IntegerProperty getItemIdProperty()
    {
        return itemIdProperty;
    }

    public IntegerProperty getStockLevelProperty()
    {
        return stockLevelProperty;
    }

    public IntegerProperty getMinStockLevelProperty()
    {
        return minStockLevelProperty;
    }

    //endregion

    @Override
    public int compareTo(Stock o)
    {
        if (this.StockID > o.getStockID())
        {
            return 1;
        }
        else if (this.StockID < o.StockID)
        {
            return -1;
        }
        return 0;
    }
}
