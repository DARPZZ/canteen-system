package DaoObjects;


public class Stock
{
    private int StockID;
    private int ItemID;
    private  int StockLevel;
    private  int MinStockLevel;


    public Stock(int stockID,int itemID, int stockLevel, int minStockLevel) {
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
}
