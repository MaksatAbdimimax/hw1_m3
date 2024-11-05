package com.geeks.hw1_m3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvCountery;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCountery = findViewById(R.id.tvCounter);
        Button btnIncrease = findViewById(R.id.btnIncrease);
        Button btnDecrease = findViewById(R.id.btnDecrease);
        Button btnSendWhatsApp = findViewById(R.id.btnSendWhatsApp);


        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                tvCountery.setText(String.valueOf(counter));
            }
        });


        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    counter--;
                }
                tvCountery.setText(String.valueOf(counter));
            }
        });


        btnSendWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCounterToWhatsApp(counter);
            }
        });
    }


    private void sendCounterToWhatsApp(int counterValue) {
        String message = "Счетчик: " + counterValue;


        String phoneNumber = "+996995050312";

        Uri uri = Uri.parse("https://wa.me/" + phoneNumber + "?text=" + Uri.encode(message));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.whatsapp");

        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();

            tvCountery.setText("WhatsApp не найден! Пожалуйста загрузите WhatsApp");
        }
    }
}
