package ca.vgorbov.gorbovshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
    }

}
