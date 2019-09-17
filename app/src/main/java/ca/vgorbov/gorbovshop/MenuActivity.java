package ca.vgorbov.gorbovshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Menu Activity which allows the client to add or remove items from the cart, see item quantities
 * and subtotals.
 */
public class MenuActivity extends AppCompatActivity {

    protected ShoppingCart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cart = new ShoppingCart();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    // Event handler from when card 1 '+' button is pressed
    public void card1PlusButtonPressed(View view) {
        addToCart(view);
    }

    // Event handler from when card 1 '-' button is pressed
    public void card1MinusButtonPressed(View view) {
        removeFromCart(view);
    }

    // Event handler from when card 2 '+' button is pressed
    public void card2PlusButtonPressed(View view) {
        addToCart(view);
    }

    // Event handler from when card 2 '-' button is pressed
    public void card2MinusButtonPressed(View view) {
        removeFromCart(view);
    }

    // Event handler from when card 3 '+' button is pressed
    public void card3PlusButtonPressed(View view) {
        addToCart(view);
    }

    // Event handler from when card 3 '-' button is pressed
    public void card3MinusButtonPressed(View view) {
        removeFromCart(view);
    }

    /**
     * General method which handles the button click events when items are added to the shopping cart.
     *
     * @param view is the button view
     */
    public void addToCart(View view) {
        // Declare variables
        int priceValue;
        String itemNameStr;
        String priceStr;
        ViewGroup layout;
        TextView itemName;
        TextView price;
        TextView quantity;
        TextView subtotal;

        // Create new menuItem
        MenuItem newItem = new MenuItem();

        // Get the entire ViewGroup layout
        layout = (ViewGroup) view.getParent();

        // Get the price, quantity, itemName and subtotal 'views'
        price = (TextView) layout.getChildAt(5);
        quantity = (TextView) layout.getChildAt(6);
        subtotal = (TextView) layout.getChildAt(7);
        itemName = (TextView) layout.getChildAt(0);

        // Get itemName str and assign it to the new item
        itemNameStr = (String) itemName.getText();
        newItem.setItemName(itemNameStr);

        // Assign code to new item
        newItem.setItemCode(layout.getId());
        Log.d("Layout ID: ", "" + layout.getId());

        // Get price string, convert to int and set item price
        priceStr = (String) price.getText();
        priceStr = priceStr.substring(1);
        priceValue = Integer.parseInt(priceStr);
        newItem.setItemPrice(priceValue);

        // Add item to cart
        cart.addItem(newItem);

        // Update Quantity
        quantity.setText("Quantity: " + cart.getItemCountById(layout.getId()));

        // Update Subtotal
        subtotal.setText("Subtotal: " + cart.getItemCountById(layout.getId()) * priceValue);
    }

    /**
     * General method which handles the button click events when items are removed from the shopping
     * cart.
     * @param view is the button view
     */
    public void removeFromCart(View view) {
        // Declare variables
        int priceValue;
        String priceStr;
        ViewGroup layout;
        TextView price;
        TextView quantity;
        TextView subtotal;

        // Get the entire ViewGroup layout
        layout = (ViewGroup) view.getParent();

        // Remove item and if successful update cart and quantity/subtotal
        if (cart.removeItem(cart.getItemById(layout.getId()))) {

            // Get the price, quantity, itemName and subtotal 'views'
            price = (TextView) layout.getChildAt(5);
            quantity = (TextView) layout.getChildAt(6);
            subtotal = (TextView) layout.getChildAt(7);

            // Get price string, convert to int and set item price
            priceStr = (String) price.getText();
            priceStr = priceStr.substring(1);
            priceValue = Integer.parseInt(priceStr);

            // Update Quantity
            quantity.setText("Quantity: " + cart.getItemCountById(layout.getId()));

            // Update Subtotal
            subtotal.setText("Subtotal: " + cart.getItemCountById(layout.getId()) * priceValue);
        }


    }

    /**
     * Method to launch the checkout activity
     * @param view is the 'proceed to checkout' button view
     */
    public void launchCheckout(View view) {
        Intent intent = new Intent(MenuActivity.this, CheckoutActivity.class);
        intent.putExtra("Cart", cart);
        startActivity(intent);
    }
}
