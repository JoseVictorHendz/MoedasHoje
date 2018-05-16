package com.example.ramonsl.moedashoje;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ramonsl on 15/05/2018.
 */

public class StocksAdapter extends ArrayAdapter<Stocks> {

    public StocksAdapter(@NonNull Context context, @NonNull List<Stocks> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Stocks bolsas= getItem(position);

        View listStocks= convertView;
        if(convertView==null) {
            listStocks= LayoutInflater.from(getContext()).inflate(R.layout.stock_item,null);

        }
        TextView txtName= listStocks.findViewById(R.id.txtName);
        TextView txtLocation= listStocks.findViewById(R.id.txtLocation);
        TextView txtVariation= listStocks.findViewById(R.id.txtVariation);

        txtName.setText(bolsas.getName());
        txtLocation.setText(bolsas.getLocation());
        txtVariation.setText(bolsas.getVariation());

        return listStocks;
    }

}
