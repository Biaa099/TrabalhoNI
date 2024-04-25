package com.example.trabalhoni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Saude extends AppCompatActivity {

    private EditText editpeso, editaltura;
    private TextView txtpeso,txtaltura, IMC, classificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);

        editpeso = findViewById(R.id.peso);
        editaltura = findViewById(R.id.altura);
        IMC = findViewById(R.id.imc);
        txtpeso = findViewById(R.id.txtpeso);
        txtaltura = findViewById(R.id.txtaltura);
        classificacao = findViewById(R.id.classificacao);

        Button button =findViewById(R.id.btn_encerrars);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Saude.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void calcular2(View view){
        String peso = editpeso.getText().toString();
        String altura = editaltura.getText().toString();

        Boolean resultado = validaDados(peso, altura);
        if(resultado){
            Double valor1 = Double.parseDouble(peso);
            Double valor2 = Double.parseDouble(altura);

            Double calculoIMC = valor1 / (valor2 * valor2);

            txtaltura.setText("Altura: " + altura);
            txtpeso.setText("Peso: " + peso);
            IMC.setText("IMC: " + calculoIMC);

            if(calculoIMC < 18.5){
                classificacao.setText("Abaixo do peso");
            }else if(calculoIMC < 25){
                classificacao.setText("Peso ideal");
            }else if(calculoIMC < 30){
                classificacao.setText("Sobrepeso");
            }else{
                classificacao.setText("Obesidade");
            }
        }
    }

    private Boolean validaDados(String peso, String altura) {
        Boolean camposValidados = true;

        if (peso == null || peso.equals("")) {
            camposValidados = false;
        } else if (altura == null || altura.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }

    public void apagar(View view){
        editpeso.setText("");
        editaltura.setText("");
    }
}