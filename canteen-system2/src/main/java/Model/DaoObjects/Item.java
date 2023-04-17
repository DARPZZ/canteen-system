package Model.DaoObjects;

import javafx.beans.property.*;

public class Item
{
    private int ItemID;
    private String Name;
    private float Price;
    private IntegerProperty itemIDProperty;
    private StringProperty nameProperty;
    private FloatProperty priceProperty;



    public Item(int itemID, String name, float price)
    {
        ItemID = itemID;
        Name = name;
        Price = price;

        itemIDProperty = new SimpleIntegerProperty(itemID);
        nameProperty = new SimpleStringProperty(name);
        priceProperty = new SimpleFloatProperty(price);
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


    public SimpleIntegerProperty getItemIDProperty()
    {
        SimpleIntegerProperty out = new SimpleIntegerProperty(ItemID);
        return out;
    }

    public void setItemIDProperty(int itemIDProperty)
    {

        this.itemIDProperty.set(itemIDProperty);
    }


    public SimpleStringProperty getNameProperty()
    {
        SimpleStringProperty out = new SimpleStringProperty(Name);
        return out;
    }

    public void setNameProperty(String nameProperty)
    {
        this.nameProperty.set(nameProperty);
    }
    public SimpleFloatProperty getPriceProperty()
    {
        SimpleFloatProperty out = new SimpleFloatProperty(Price);
        return out;
    }

    public void setPriceProperty(float priceProperty) {
        this.priceProperty.set(priceProperty);
    }
}
