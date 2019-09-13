package ca.vgorbov.gorbovshop;

import java.util.ArrayList;

public class ShoppingCart {
    private int itemCount;
    private int cartSubtotal;
    private ArrayList<MenuItem> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
        itemCount = 0;
        cartSubtotal = 0;
    }

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

    public void displayCartContents() {
        //TO DO
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

    public int countItemsById(int id) {
        int count = 0;

        for (MenuItem item : cart)
            if (item.getItemCode() == id) {
                count++;
            }

        return count;
    }
}
