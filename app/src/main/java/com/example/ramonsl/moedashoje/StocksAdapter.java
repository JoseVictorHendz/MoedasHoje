package com.example.ramonsl.moedashoje;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class StocksAdapter  extends ArrayAdapter<Stocks>{

    public StocksAdapter(@NonNull Context context, @NonNull List<Stocks> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Stocks bolsa= getItem(position);

        View listStocks= convertView;
        if(convertView==null) {
            listStocks= LayoutInflater.from(getContext()).inflate(R.layout.currencies_item,null);

        }
        TextView name= listStocks.findViewById(R.id.txtNameStocks);
        TextView txtLocation= listStocks.findViewById(R.id.txtLocationStocks);
        TextView variacao= listStocks.findViewById(R.id.txtVariacaoStocks);
        name.setText(bolsa.getName());
        txtLocation.setText(bolsa.getLocation());
        variacao.setText(bolsa.getVariation());


        return listStocks;
    }
}
