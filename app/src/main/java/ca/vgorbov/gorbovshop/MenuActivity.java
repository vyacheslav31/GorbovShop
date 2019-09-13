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

    int priceValue;
    int subtotalValue;
    int qtyValue;
    String priceStr;
    String subtotalStr;
    String qtyStr;
    ViewGroup layout;
    TextView price;
    TextView quantity;
    TextView subtotal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void addToCart(View view) {

        // Get the price, quantity and subtotal 'views'
        layout = (ViewGroup) view.getParent();
        price = (TextView) layout.getChildAt(5);
        quantity = (TextView) layout.getChildAt(6);
        subtotal = (TextView) layout.getChildAt(7);


        // Convert price to an int
        priceStr = (String) price.getText();
        priceStr = priceStr.substring(0 , 3);
        priceValue = Integer.parseInt(priceStr);

        // Convert quantity to an int
        qtyStr = (String) quantity.getText();
        qtyStr = qtyStr.substring(10);
        qtyValue = Integer.parseInt(qtyStr);

        // Convert Subtotal to an int
        subtotalStr = (String) subtotal.getText();
        subtotalStr = subtotalStr.substring(10);
        subtotalValue = Integer.parseInt(subtotalStr);




    }

    public void removeFromCart(View view) {
    }
}
