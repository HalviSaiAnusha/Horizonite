package com.example.horizonite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Payment extends AppCompatActivity implements PaymentResultListener {

    private Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Checkout.preload(getApplicationContext());
        pay=(Button)findViewById(R.id.button4);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText amount = findViewById(R.id.amt);
                String total = amount.getText().toString();
                setUpPayment(total);
            }
        });
    }

    private void setUpPayment(String amt) {
        final Activity activity = this;
        final Checkout checkout =new Checkout();

        JSONObject object = new JSONObject();
        try {
            object.put("name","Horizonite");
            object.put("description","Payment Gateway");
            object.put("image",""+R.drawable.razorpay);
            object.put("Currency","INR");

            double total = Double.parseDouble(amt);
            total = total*100;
            object.put("amount",total);
            checkout.open(activity,object);
        } catch (JSONException e) {
            Toast.makeText(activity, "Exception : "+e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Successful"+s, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Payment.this,Home.class);
        startActivity(i);
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Failed"+s, Toast.LENGTH_SHORT).show();
    }
}