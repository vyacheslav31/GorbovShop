package ca.vgorbov.gorbovshop;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuItem implements Parcelable {
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

    protected MenuItem(Parcel in) {
        itemName = in.readString();
        itemPrice = in.readInt();
        itemCode = in.readInt();
    }

    public static final Creator<MenuItem> CREATOR = new Creator<MenuItem>() {
        @Override
        public MenuItem createFromParcel(Parcel in) {
            return new MenuItem(in);
        }

        @Override
        public MenuItem[] newArray(int size) {
            return new MenuItem[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemName);
        dest.writeInt(itemPrice);
        dest.writeInt(itemCode);
    }
}
