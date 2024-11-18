package com.example.izdatelstva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button litresButton = findViewById(R.id.btn_litres);
        Button eksmoButton = findViewById(R.id.btn_eksmo);
        Button labirintButton = findViewById(R.id.btn_labirint);
        Button prosvButton = findViewById(R.id.btn_prosv);

        litresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, litres.class);
                startActivity(intent);
            }
        });

        // Переход на активность Eksmo
        eksmoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, eksmo.class);
                startActivity(intent);
            }
        });

        // Переход на активность Labirint
        labirintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, labirint.class);
                startActivity(intent);
            }
        });

        prosvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, prosv.class);
                startActivity(intent);
            }
        });
    }
}