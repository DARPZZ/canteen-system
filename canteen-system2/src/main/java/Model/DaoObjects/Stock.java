package Model.DaoObjects;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

public class Stock implements Comparable<Stock>
{

    private IntegerProperty stockIdProperty;
    private IntegerProperty itemIdProperty;
    private IntegerProperty stockLevelProperty;
    private IntegerProperty minStockLevelProperty;
    private StringProperty itemNameProperty;
    private StringProperty supplierNameProperty;

    public Stock(int stockID, int itemID, int stockLevel, int minStockLevel)
    {
        this.stockIdProperty = new SimpleIntegerProperty(stockID);
        this.itemIdProperty = new SimpleIntegerProperty(itemID);
        this.stockLevelProperty = new SimpleIntegerProperty(stockLevel);
        this.minStockLevelProperty = new SimpleIntegerProperty(minStockLevel);
    }

    public Stock(int stockID, int itemID)
    {
        this.stockIdProperty = new SimpleIntegerProperty(stockID);
        this.itemIdProperty = new SimpleIntegerProperty(itemID);
    }

    public Stock(int stockID, int stockLevel, int minStockLevel)
    {
        this.stockIdProperty = new SimpleIntegerProperty(stockID);
        this.stockLevelProperty = new SimpleIntegerProperty(stockLevel);
        this.minStockLevelProperty = new SimpleIntegerProperty(minStockLevel);
    }
//start region
    public int getStockIdProperty() {
        return stockIdProperty.get();
    }

    public IntegerProperty getStockIDProperty() {
        return stockIdProperty;
    }

    public void setStockIdProperty(int stockIdProperty) {
        this.stockIdProperty.set(stockIdProperty);
    }

    public int getItemIdProperty() {
        return itemIdProperty.get();
    }

    public IntegerProperty getItemIDProperty() {
        return itemIdProperty;
    }

    public void setItemIdProperty(int itemIdProperty) {
        this.itemIdProperty.set(itemIdProperty);
    }

    public int getStockLevelProperty()
    {
        return stockLevelProperty.get();
    }

    public void setStockLevelProperty(int stockLevelProperty) {
        this.stockLevelProperty.set(stockLevelProperty);
    }

    public int getMinStockLevelProperty() {
        return minStockLevelProperty.get();
    }

    public void setMinStockLevelProperty(int minStockLevelProperty) {
        this.minStockLevelProperty.set(minStockLevelProperty);
    }

    //endregion


    @Override
    public int compareTo(Stock o)
    {
        if (this.stockIdProperty.get() > o.getStockIdProperty())
        {
            return 1;
        }
        else if (this.stockIdProperty.get() < o.getStockIdProperty())
        {
            return -1;
        }
        return 0;
    }
}
