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

    Button addToCartButton;
    Button removeFromCartButton;
    TextView qtyTextView;
    TextView subtotalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void addToCart(View view) {
        ViewGroup layout = (ViewGroup) view.getParent();
        TextView price = (TextView) layout.getChildAt(5);
    }

    public void removeFromCart(View view) {
    }
}
