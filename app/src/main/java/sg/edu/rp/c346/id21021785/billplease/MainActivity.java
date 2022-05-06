package sg.edu.rp.c346.id21021785.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    EditText pax;
    ToggleButton svc;
    ToggleButton gst;
    EditText discount;
    RadioGroup payment;
    Button calculate;
    Button reset;
    TextView total;
    TextView gstAmt;
    TextView svcAmt;
    TextView split;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.amountNo);
        pax = findViewById(R.id.paxNo);
        svc = findViewById(R.id.svc);
        gst = findViewById(R.id.gst);
        discount = findViewById(R.id.discountNo);
        payment = findViewById(R.id.paymentMethod);
        calculate = findViewById(R.id.calculate);
        reset = findViewById(R.id.reset);
        total = findViewById(R.id.total);
        gstAmt = findViewById(R.id.gstView);
        svcAmt = findViewById(R.id.svcView);
        split = findViewById(R.id.perPerson);


        svc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (svc.isChecked()) {
                    double newSvc = 0.1;
                } else {
                    double newSvc = 0.0;
                }
            }
        });

        gst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gst.isChecked()) {
                    double newGst = 0.07;
                } else {
                    double newGst = 0.0;
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double newAmount = Double.parseDouble(amount.getText().toString());
                int newPax = Integer.parseInt(pax.getText().toString());
                double newDiscount = Double.parseDouble(discount.getText().toString());
                double newGst = 0.0;
                double newSvc = 0.0;

                if (svc.isChecked()) {
                    newSvc = 0.1;
                } else {
                    newSvc = 0.0;
                }

                if (gst.isChecked()) {
                    newGst = 0.07;
                } else {
                    newGst = 0.0;
                }

                if (newAmount > 0 && newPax > 0) {
                    double newTotal = newAmount * ((100 - newDiscount)/100) + (newGst * newAmount) + (newSvc * newAmount);                }
            }
        });



    }
}