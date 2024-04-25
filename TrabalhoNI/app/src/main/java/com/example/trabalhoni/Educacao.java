package com.example.trabalhoni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Educacao extends AppCompatActivity {

    private EditText editnota1, editnota2, editnota3;
    private TextView textoaprovacao, media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educacao);

        editnota1 = findViewById(R.id.entradanota1);
        editnota2 = findViewById(R.id.entradanota2);
        editnota3 = findViewById(R.id.entradanota3);
        textoaprovacao = findViewById(R.id.aprovacao);
        media = findViewById(R.id.mediaTotal);

        Button button = findViewById(R.id.btn_encerrare);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Educacao.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void apagar(View view){
        editnota1.setText("");
        editnota2.setText("");
        editnota3.setText("");
    }
    public void calcular1(View view) {
        String nota1 = editnota1.getText().toString();
        String nota2 = editnota2.getText().toString();
        String nota3 = editnota3.getText().toString();


        Boolean resultado = validaDados(nota1, nota2, nota3);
        if(resultado){
            Double valor1 = Double.parseDouble(nota1);
            Double valor2 = Double.parseDouble(nota2);
            Double valor3 = Double.parseDouble(nota3);

            Double calculoMedia = (valor1 + valor2 + valor3) / 3;

            media.setText("A média é: " + calculoMedia);

            if(calculoMedia >= 6){
                textoaprovacao.setText("APROVADO");
            }else {
                textoaprovacao.setText("REPROVADO");
            }
        }
    }

    private Boolean validaDados(String nota1, String nota2, String nota3) {
        Boolean camposValidados = true;

        if (nota1 == null || nota1.equals("")) {
            camposValidados = false;
        } else if (nota2 == null || nota2.equals("")) {
            camposValidados = false;
        } else if (nota3 == null || nota3.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }
}