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
        checkoutTextView.setText(String.format("%-25s%-10s%s", "Item", "Qty", "Price\n"));
        checkoutTextView.append("--------------------------------------------\n");

        if (!ids.isEmpty()) {
            for (int id : ids) {
                checkoutTextView.append(String.format("\n%-26s%-10s%s\n", cart.getItemNameById(id), cart.getItemQtyById(id), cart.getItemPriceById(id)));
            }
            checkoutTextView.append(String.format("\n\n\n\n\nSubtotal: %d\nTPS: %.2f\nTVQ: %.2f\nTotal: %.2f$", cartSubtotal, tps, tvq, total));
        }

        checkoutTextView.append("\n\nThank you very much for using my application!\nHave a great day :)");
    }

}
