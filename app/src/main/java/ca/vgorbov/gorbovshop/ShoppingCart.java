package ca.vgorbov.gorbovshop;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ShoppingCart implements Parcelable {
    private int itemCount;
    private int cartSubtotal;
    private ArrayList<MenuItem> cart;

    // Default Constructor
    public ShoppingCart() {
        cart = new ArrayList<>();
        itemCount = 0;
        cartSubtotal = 0;
    }


    protected ShoppingCart(Parcel in) {
        itemCount = in.readInt();
        cartSubtotal = in.readInt();
        cart = in.createTypedArrayList(MenuItem.CREATOR);
    }

    public static final Creator<ShoppingCart> CREATOR = new Creator<ShoppingCart>() {
        @Override
        public ShoppingCart createFromParcel(Parcel in) {
            return new ShoppingCart(in);
        }

        @Override
        public ShoppingCart[] newArray(int size) {
            return new ShoppingCart[size];
        }
    };

    public boolean addItem(MenuItem item) {
        itemCount++;
        cartSubtotal += item.getItemPrice();
        return cart.add(item);
    }

    public boolean removeItem(MenuItem item) {
        if (!cart.isEmpty()) {
            itemCount--;
            cartSubtotal -= item.getItemPrice();
            return cart.remove(item);
        }
        else
            return false;

    }

    public int getItemCount() {
        return itemCount;
    }

    public int getCartSubtotal() {
        return cartSubtotal;
    }

    public MenuItem getItemById(int id) {
        for (MenuItem item : cart)
            if (item.getItemCode() == id)
                return item;
        return null;
    }

    public int getItemQtyById(int id) {
        int qty = 0;

        for (MenuItem item : cart)
            if (item.getItemCode() == id) {
                qty++;
            }

        return qty;
    }

    public String getItemNameById(int id) {
        String name = "";

        for (MenuItem item : cart)
        if (item.getItemCode() == id) {
            return item.getItemName();
        }

        return null;
    }

    public int getItemCountById(int id) {
        int count = 0;

        for (MenuItem item : cart)
            if (item.getItemCode() == id) {
                count++;
            }

        return count;
    }

    public int getItemPriceById(int id) {
        for (MenuItem item : cart)
            if (item.getItemCode() == id) {
                return item.getItemPrice();
            }

        return 0;
    }

    public ArrayList<Integer> getIds() {
        ArrayList<Integer> uniqueIds = new ArrayList();

        for (MenuItem item : cart)
            if (!uniqueIds.contains(item.getItemCode())) {
                uniqueIds.add(item.getItemCode());
            }

        return uniqueIds;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(itemCount);
        dest.writeInt(cartSubtotal);
        dest.writeTypedList(cart);
    }
}
