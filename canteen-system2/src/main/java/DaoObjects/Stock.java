package DaoObjects;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Stock implements Comparable<Stock>
{
    private int StockID;
    private IntegerProperty stockIdProperty;
    private int ItemID;
    private IntegerProperty itemIdProperty;
    private int StockLevel;
    private IntegerProperty stockLevelProperty;
    private int MinStockLevel;
    private IntegerProperty minStockLevelProperty;


    public Stock(int stockID,int itemID, int stockLevel, int minStockLevel)
    {
        this.StockID = stockID;
        this.ItemID = itemID;
        this.StockLevel = stockLevel;
        this.MinStockLevel = minStockLevel;

    }
    public Stock(int stockID, int itemID)
    {
        this.StockID = stockID;
        this.ItemID = itemID;
    }

    public Stock(int stockID, int stockLevel, int minStockLevel)
    {
        StockID = stockID;
        stockIdProperty = new SimpleIntegerProperty(stockID);

        StockLevel = stockLevel;
        stockLevelProperty = new SimpleIntegerProperty(stockLevel);

        MinStockLevel = minStockLevel;
        minStockLevelProperty = new SimpleIntegerProperty(minStockLevel);
    }

    public int getStockID() {
        return StockID;
    }

    public void setStockID(int stockID) {
        StockID = stockID;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public int getStockLevel() {
        return StockLevel;
    }

    public void setStockLevel(int stockLevel) {
        StockLevel = stockLevel;
    }

    public int getMinStockLevel() {
        return MinStockLevel;
    }

    public void setMinStockLevel(int minStockLevel) {
        MinStockLevel = minStockLevel;
    }

    //region property get/set

    public IntegerProperty getStockIdProperty()
    {
        return stockIdProperty;
    }

    public void setStockIdProperty(int stockIdProperty)
    {
        this.stockIdProperty.set(stockIdProperty);
    }

    public IntegerProperty getItemIdProperty()
    {
        return itemIdProperty;
    }

    public void setItemIdProperty(int itemIdProperty)
    {
        this.itemIdProperty.set(itemIdProperty);
    }

    public IntegerProperty getStockLevelProperty()
    {
        return stockLevelProperty;
    }

    public void setStockLevelProperty(int stockLevelProperty)
    {
        this.stockLevelProperty.set(stockLevelProperty);
    }

    public IntegerProperty getMinStockLevelProperty()
    {
        return minStockLevelProperty;
    }

    public void setMinStockLevelProperty(int minStockLevelProperty)
    {
        this.minStockLevelProperty.set(minStockLevelProperty);
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
