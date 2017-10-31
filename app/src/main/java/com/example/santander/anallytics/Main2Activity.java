package com.example.santander.anallytics;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main2Activity extends ActionBarActivity{

    //criação dos objectos
    EditText editLogin;
    EditText editSenha;
    Button btnAcessar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Vinculando os objectos aos seus ids
        editLogin = (EditText) findViewById(R.id.editLogin);
        editSenha = (EditText) findViewById(R.id.editSenha);
        btnAcessar = (Button) findViewById(R.id.btnAcessar);

        //botao acessar
        btnAcessar.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v){

                        if(editLogin.getText().toString().equals("csa") && editSenha.getText().toString().equals("csa")){


                            Intent it= new Intent(Main2Activity.this, MainActivity.class);
                            startActivity(it);
                            finish();
                        }

                        else{
                            Toast.makeText(Main2Activity.this, "Tente novamente", Toast.LENGTH_SHORT).show();

                        }
                    }


                });


    }

}
