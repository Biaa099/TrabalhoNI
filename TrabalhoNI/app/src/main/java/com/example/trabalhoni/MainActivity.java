package com.example.trabalhoni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button =findViewById(R.id.btn_finan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Financeiro.class);
                startActivity(intent);
            }
        });
        Button button1 =findViewById(R.id.btn_edu);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Educacao.class);
                startActivity(intent);
            }
        });
        Button button2 =findViewById(R.id.btn_saude);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Saude.class);
                startActivity(intent);
            }
        });
        Button button3 =findViewById(R.id.btn_info);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Info.class);
                startActivity(intent);
            }
        });
    }

}