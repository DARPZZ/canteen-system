package DaoObjects;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Item
{
    private int ItemID;
    private IntegerProperty itemIDProperty;
    private String description;
    private StringProperty descriptionProperty;

    private int quantity;
    private IntegerProperty quantityProperty;
    private String Name;
    private float Price;
    private FloatProperty priceProperty;

    public Item(int itemID, String name, float price) {
        ItemID = itemID;
        Name = name;
        Price = price;
    }
    public Item(int itemID, String name)
    {
        ItemID = itemID;
        Name = name;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
}
