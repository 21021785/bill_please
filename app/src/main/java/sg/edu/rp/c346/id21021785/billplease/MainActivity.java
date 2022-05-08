package sg.edu.rp.c346.id21021785.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
    RadioButton cash;
    RadioButton payNow;
    Button calculate;
    Button reset;
    TextView total;
    TextView gstAmt;
    TextView svcAmt;
    TextView split;
    TextView payTo;

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
        cash = findViewById(R.id.cash);
        payNow = findViewById(R.id.payNow);
        calculate = findViewById(R.id.calculate);
        reset = findViewById(R.id.reset);
        total = findViewById(R.id.total);
        gstAmt = findViewById(R.id.gstView);
        svcAmt = findViewById(R.id.svcView);
        split = findViewById(R.id.perPerson);
        payTo = findViewById(R.id.payTo);



        svc.setTag(0.0);
        svc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (svc.isChecked()) {
                    svc.setTag(0.1);
                } else {
                    svc.setTag(0);
                }
            }
        });

        gst.setTag(0.07);
        gst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gst.isChecked()) {
                    gst.setTag(0.07);
                } else {
                    gst.setTag(0);
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double newAmount = 0.0;
                if (amount.getText() != null) {
                    newAmount = Double.parseDouble(amount.getText().toString());
                } else {
                    newAmount = Double.parseDouble(amount.getTag().toString());
                }

                int newPax = 0;
                if (pax.getText() != null) {
                    newPax = Integer.parseInt(pax.getText().toString());
                } else {
                    newPax = Integer.parseInt(pax.getTag().toString());
                }


                double newDiscount = 0.0;
                if (discount.getText() != null) {
                    newDiscount = Double.parseDouble(discount.getText().toString());
                } else {
                    newDiscount = Double.parseDouble(discount.getTag().toString());
                }

                double newTotal = 0.0;
                double newSvc = Double.parseDouble(svc.getTag().toString());
                System.out.println(gst.getTag());
                double newGst = Double.parseDouble(gst.getTag().toString());
                int checkedRadioId = payment.getCheckedRadioButtonId();

                System.out.println(R.id.payNow);

                if(checkedRadioId == R.id.cash){
                    payTo.setText("Pay via cash to John");
                } else if (checkedRadioId == R.id.payNow) {
                    payTo.setText("Pay via PayNow to John (91234567)");
                } else {
                    payTo.setText("");
                }

                if (newAmount != 0.0 || newPax != 0 || newDiscount != 0.0 ) {
                    newTotal = ((newAmount + (newGst * newAmount) + (newSvc * newAmount)) * (100 - newDiscount)/100);
                } else {
                    newTotal = 0;
                }

                total.setText(String.format("Total: $%.2f", newTotal));
                gstAmt.setText(String.format("GST: $%.2f", (newGst * newAmount)));
                svcAmt.setText(String.format("Service Charge: $%.2f", (newSvc * newAmount)));
                split.setText(String.format("Each Person Pays: $%.2f", (newTotal/newPax)));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount.setText("");
                pax.setText("");
                discount.setText("");
            }
        });




    }
}