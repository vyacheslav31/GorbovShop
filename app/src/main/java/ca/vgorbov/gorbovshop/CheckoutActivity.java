package ca.vgorbov.gorbovshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        displayOrderInfo();
    }

    private void displayOrderInfo() {
        Intent intent = getIntent();
        ShoppingCart cart = intent.getParcelableExtra("Cart");
        TextView checkoutTextView = findViewById(R.id.checkout_textview);

        int cartSubtotal = cart.getCartSubtotal();
        double tps = cart.getCartSubtotal() * 0.05;
        double tvq = cart.getCartSubtotal() * 0.0975;
        double total = cartSubtotal + tps + tvq;
        ArrayList<Integer> ids = cart.getIds();
        checkoutTextView.setText(String.format("%-45s%-20s%s", "Item", "Qty", "Price\n"));
        checkoutTextView.append("-------------------------------------------------------------------------\n");
        checkoutTextView.append(String.format("\n%-36s%-20s%s", cart.getItemNameById(ids.get(0)), cart.getItemQtyById(ids.get(0)), cart.getItemPriceById(ids.get(0))));
        checkoutTextView.append(String.format("\n%-30s%-20s%s", cart.getItemNameById(ids.get(1)), cart.getItemQtyById(ids.get(1)), cart.getItemPriceById(ids.get(1))));
        checkoutTextView.append(String.format("\n%-37s%-20s%s", cart.getItemNameById(ids.get(2)), cart.getItemQtyById(ids.get(2)), cart.getItemPriceById(ids.get(2))));
        checkoutTextView.append(String.format("\n\n\n\n\nSubtotal: %d\nTPS: %.2f\nTVQ: %.2f\nTotal: %.2f", cartSubtotal, tps, tvq, total));
    }

}
