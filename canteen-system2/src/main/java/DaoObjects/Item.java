package DaoObjects;

public class Item
{
    private int ItemID;
    private String Name;
    private float Price;

    public Item(String name, float price) {

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
