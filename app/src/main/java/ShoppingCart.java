import java.util.ArrayList;

public class ShoppingCart {
    private int itemCount;
    private int cartSubtotal;
    ArrayList<MenuItem> cart;

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
}
