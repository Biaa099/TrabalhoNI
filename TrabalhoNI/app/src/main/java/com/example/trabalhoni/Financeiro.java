package com.example.trabalhoni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Financeiro extends AppCompatActivity {

    private EditText editsalario;
    private TextView salariobruto, descontoinss, descontofgts,salarioliquido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financeiro);

        editsalario = findViewById(R.id.salario);
        salariobruto = findViewById(R.id.sbruto);
        descontoinss = findViewById(R.id.inss);
        descontofgts = findViewById(R.id.fgts);
        salarioliquido = findViewById(R.id.sliquido);


        Button button =findViewById(R.id.btn_encerrar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Financeiro.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void calcular3(View view){
        String salario = editsalario.getText().toString();
        double descontoi = 0;
        double descontof = 0;
        double salariol = 0;

        salariobruto.setText("Salário Bruto: " + salario);
        Double valor1 = Double.parseDouble(salario);


        Boolean resultado = validaDados(salario);

        if(resultado){

            descontof = valor1 * 0.08;
            descontofgts.setText("R$" + descontof);

            if (valor1 <= 1100.00) {
                descontoi = valor1 * 0.075;
                descontoinss.setText("R$" + descontoi);
            } else if (valor1 <= 2203.48) {
                descontoi = valor1 * 0.09;
                descontoinss.setText("R$" + descontoi);
            } else if (valor1 <= 3305.22) {
                descontoi = valor1 * 0.12;
                descontoinss.setText("R$" + descontoi);
            } else if (valor1 <= 6433.57) {
                descontoi = valor1 * 0.14;
                descontoinss.setText("R$" + descontoi);
            } else {
                descontoi = 6433.57 * 0.14;
                descontoinss.setText("R$" + descontoi);
            }

            salariol = (valor1 - descontof - descontoi) /1 ;
            salarioliquido.setText("R$" + salariol);

        }
    }
    private Boolean validaDados(String salario) {
        Boolean camposValidados = true;

        if (salario == null || salario.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }

    public void apagar(View view){
        editsalario.setText("");
    }
}