package br.edu.unifcv.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Variaveis que contém no layout;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnSoma, btnDiv, btnSub, btnMult, btnApagar, btnVirgula, btnIgual;
    EditText Result;
    String operacao;
    double n1, n2;
    Boolean bVirgula = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referencia as ID (variavel referencia o elemento que possui a ID);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnSoma = (Button) findViewById(R.id.btnSoma);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnApagar = (Button) findViewById(R.id.btnApagar);
        btnVirgula = (Button) findViewById(R.id.btnVirgula);
        Result = (EditText) findViewById(R.id.Result);


        btnVirgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bVirgula = true){
                    Result.setText(Result.getText() + ".");
                bVirgula = false;
                }else{

                }
            }
        });

        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result.setText("");

            }
        });

        //Evento para todos  os botões numéricos (0 - 9)(faz o evento acontecer referenciando os botões numericos)
        View.OnClickListener numericButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = findViewById(view.getId());
                    Result.setText(Result.getText().toString() + btn.getText());
            }
        };
        //Evento da operação
        View.OnClickListener operationButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = findViewById(view.getId());
                operacao = btn.getText().toString();
                n1 = Double.valueOf(Result.getText().toString());
                Result.setText("");
                bVirgula = false;
            }
        };
        //Evento para fazer o calculo
        View.OnClickListener equalsButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n2 = Double.valueOf(Result.getText().toString());
                if (operacao.equals("+")) {

                    Result.setText(n1 + n2 + "");

                }

                if (operacao.equals("-")) {

                    Result.setText(n1 - n2 + "");
                }

                if (operacao.equals("X")) {

                    Result.setText(n1 * n2 + "");

                }
                if (operacao.equals("÷")) {
                    if (n2 != 0)
                        Result.setText(n1 / n2 + "");
                    else
                       Toast.makeText(MainActivity.this, "Impossível divisão por zero", Toast.LENGTH_LONG).show();
                }
                bVirgula = false;
            }
        };
        //Monitorar quando o botão for clicado;
        btn0.setOnClickListener(numericButton);
        btn1.setOnClickListener(numericButton);
        btn2.setOnClickListener(numericButton);
        btn3.setOnClickListener(numericButton);
        btn4.setOnClickListener(numericButton);
        btn5.setOnClickListener(numericButton);
        btn6.setOnClickListener(numericButton);
        btn7.setOnClickListener(numericButton);
        btn8.setOnClickListener(numericButton);
        btn9.setOnClickListener(numericButton);

        btnSoma.setOnClickListener(operationButton);
        btnSub.setOnClickListener(operationButton);
        btnDiv.setOnClickListener(operationButton);
        btnMult.setOnClickListener(operationButton);


        btnIgual.setOnClickListener(equalsButton);

    }

}


