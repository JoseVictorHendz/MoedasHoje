package com.example.ramonsl.moedashoje;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class StocksActivity extends AppCompatActivity {

    ArrayList<Stocks> mStock;
    StocksAdapter mAdapter;
    ListView listStocks;
    StockTask mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);
        listStocks = findViewById(R.id.listStocks);
        search();
    }


    private void search(){

        if(mStock==null){
            mStock= new ArrayList<Stocks>();
        }
        mAdapter = new StocksAdapter(getApplicationContext(),mStock);
        if(mTask== null){
            if (ServicesHttp.hasConnected(this)){
                starDownload();
            }else{
                Toast.makeText(getApplicationContext(), "Sem Wifi...", Toast.LENGTH_LONG).show();
            }
        }else if (mTask.getStatus()== AsyncTask.Status.RUNNING){
            Toast.makeText(getApplicationContext(), "...", Toast.LENGTH_LONG).show();

        }

    }


    private void starDownload(){
        if(mTask==null || mTask.getStatus()!= AsyncTask.Status.RUNNING){
            mTask = new StockTask();
            mTask.execute();
        }
    }


    class StockTask extends AsyncTask<Void,Void, ArrayList<Stocks>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(), "Pronto...", Toast.LENGTH_LONG).show();

        }

        @Override
        protected ArrayList<Stocks> doInBackground(Void... voids) {
            ArrayList<Stocks> stocksList = ServicesHttp.loadStocks();
            return stocksList;
        }

        @Override
        protected void onPostExecute(ArrayList<Stocks> stocks) {
            super.onPostExecute(stocks);
            if(stocks!=null){
                mStock.clear();
                mStock.addAll(stocks);
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}
