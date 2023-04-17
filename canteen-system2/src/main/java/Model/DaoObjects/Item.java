package Model.DaoObjects;

import javafx.beans.property.*;

public class Item {
    private IntegerProperty itemID;
    private StringProperty name;
    private FloatProperty price;


    public Item(int itemID, String name, float price) {

        this.itemID = new SimpleIntegerProperty(itemID);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleFloatProperty(price);
    }

    public int getItemID() {
        return itemID.get();
    }

    public IntegerProperty itemIDProperty() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID.set(itemID);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public float getPrice() {
        return price.get();
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }
}
