package DaoObjects;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Stock implements Comparable<Stock>
{
    private int StockID;
    private int ItemID;
    private int StockLevel;
    private int MinStockLevel;

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
        StockLevel = stockLevel;
        MinStockLevel = minStockLevel;
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

    //region property getter

    public IntegerProperty getStockIdProperty()
    {
        return new SimpleIntegerProperty(StockID);
    }

    public IntegerProperty getItemIdProperty()
    {
        return new SimpleIntegerProperty(ItemID);
    }

    public IntegerProperty getStockLevelProperty()
    {
        return new SimpleIntegerProperty(StockLevel);
    }

    public IntegerProperty getMinStockLevelProperty()
    {
        return new SimpleIntegerProperty(MinStockLevel);
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
