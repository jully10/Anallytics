package com.example.santander.anallytics;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mayragomes on 15/07/17.
 */

public class TelaAbertura extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_abertura);

        //abertura star
        Test start = new Test();
        start.execute();
    }

    //abertura
    public class Test extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids){
            try {
                Thread.sleep(2000);
                Intent in = new Intent(TelaAbertura.this, Main2Activity.class);
                startActivity(in);
                finish();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;

        }
    }//abertura
}
