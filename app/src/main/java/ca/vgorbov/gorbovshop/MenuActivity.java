package ca.vgorbov.gorbovshop;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {

    protected ShoppingCart cart;
    private int priceValue;
    private int subtotalValue;
    private int qtyValue;
    private String itemNameStr;
    private String priceStr;
    private String subtotalStr;
    private String qtyStr;
    private ViewGroup layout;
    private TextView itemName;
    private TextView price;
    private TextView quantity;
    private TextView subtotal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cart = new ShoppingCart();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void addToCart(View view) {
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

        // Get price string, convert to int and set item price
        priceStr = (String) price.getText();
        priceStr = priceStr.substring(0 , 3);
        priceValue = Integer.parseInt(priceStr);
        newItem.setItemPrice(priceValue);

        cart.addItem(newItem);
    }

    public void removeFromCart(View view) {
    }

    public void updateQuantity() {
        // Get and convert quantity string to an int
        qtyStr = (String) quantity.getText();
        qtyStr = qtyStr.substring(10);
        qtyValue = Integer.parseInt(qtyStr);
    }

    public void updateSubtotal() {
        // Get and convert subtotal string to an int
        subtotalStr = (String) subtotal.getText();
        subtotalStr = subtotalStr.substring(10);
        subtotalValue = Integer.parseInt(subtotalStr);

    }
}
