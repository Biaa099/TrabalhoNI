package com.example.trabalhoni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    private EditText editnome, editidade;
    private TextView no, id, infoaltura, peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        editnome.findViewById(R.id.nome);
        editidade.findViewById(R.id.idade);
        no.findViewById(R.id.no);
        id.findViewById(R.id.id);
        infoaltura.findViewById(R.id.altura);

        Button button =findViewById(R.id.btn_encerrarI);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Info.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void mostrar(){
        no.setText("Nome: " + no);
        infoaltura.setText("Altura: " + infoaltura);
    }


    public void apagar(View view){
        editidade.setText("");
        editnome.setText("");
    }
}