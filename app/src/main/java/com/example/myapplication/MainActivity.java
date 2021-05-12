package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_calcular;
    EditText horas;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horas = findViewById(R.id.numero);
        btn_calcular = findViewById(R.id.btn_calcular);
        resultado = findViewById(R.id.resultado);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int _horas = Integer.parseInt(horas.getText().toString());
                int diaTem = 24;
                int semanaTem = 168;
                double calcularSemana = _horas / semanaTem;
                int _semana_ = (int) Math.abs(calcularSemana);

                int horaActual = _horas - 168 * _semana_;
                int contDia = 0;
                for (int i = 1; i <= horaActual; i++ ){
                if(horaActual >= 24){
                    horaActual -= diaTem;
                    contDia++;
                }
                }
                resultado.setText("Semanas : "+ String.valueOf(_semana_) + " Dias : "+ String.valueOf(contDia)+ "Horas : "+ String.valueOf(horaActual));

            }
        });
    }
}