package com.example.ramonsl.moedashoje;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.ArrayList;
public class activitStocks  extends AppCompatActivity {
    StocksTask sTask;
    ArrayList<Stocks> sStocks;
    ListView mListStocks;
    ArrayAdapter<Stocks> sAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListStocks = findViewById(R.id.listStocks);
        search();
    }




    private void search() {
        if (sStocks == null) {
            sStocks = new ArrayList<Stocks>();
        }

        sAdapter = new StocksAdapter(getApplicationContext(), sStocks);
        mListStocks.setAdapter(sAdapter);
        if (sTask == null) {
            if (CurrenciesHttp.hasConnected(this)) {
                startDownload();
            } else {
                Toast.makeText(getApplicationContext(), "Sem conexão...", Toast.LENGTH_LONG).show();
            }
        } else if (sTask.getStatus() == AsyncTask.Status.RUNNING) {
            Toast.makeText(getApplicationContext(), "......", Toast.LENGTH_LONG).show();
        }
    }


    public void startDownload() {
        if (sTask == null || sTask.getStatus() != AsyncTask.Status.RUNNING) {
            sTask = new StocksTask();
            sTask.execute();
        }
    }

    //INNER CLASS ASICRONA
    class StocksTask extends AsyncTask<Void, Void, ArrayList<Stocks>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //showProgress(true);
            Toast.makeText(getApplicationContext(), "Pronto...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected ArrayList<Stocks> doInBackground(Void... strings) {
            ArrayList<Stocks> bolsaList = CurrenciesHttp.loadStocks();
            return bolsaList;
        }
        @Override
        protected void onPostExecute(ArrayList<Stocks> coins) {
            super.onPostExecute(coins);
            //     showProgress(false);
            if (coins != null) {
                sStocks.clear();
                sStocks.addAll(coins);
                sAdapter.notifyDataSetChanged();
            } else {

                Toast.makeText(getApplicationContext(), "Buscando...", Toast.LENGTH_LONG).show();
            }
        }
    }

}
