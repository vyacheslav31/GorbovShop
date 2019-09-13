package ca.vgorbov.gorbovshop;

public class MenuItem {
    private String itemName;
    private int itemPrice;
    private int itemCode;

    public MenuItem() {
    }

    public MenuItem(String itemName, int itemPrice, int itemCode) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCode = itemCode;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

}
