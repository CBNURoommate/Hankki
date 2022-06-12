package com.example.hankki;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Res_Adapter extends ArrayAdapter<com.example.hankki.Res_class>{
    nowMember nm;
    public Res_Adapter(Context context, int resource, List <com.example.hankki.Res_class> Res_list, nowMember nm){
        super(context, resource, Res_list);
        this.nm=nm;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        int distance;
        int minute;
        double x;
        double y;

        com.example.hankki.Res_class restaurant = getItem(position);


        x = Math.pow (36.625627/*nm.getLatitude()*/ - restaurant.getLatitude(),2);
        y = Math.pow (127.454416/*nm.getLongitude()*/ - restaurant.getLongitude(),2);

        distance = (int) ((x+y)*10000000);

        minute = distance/66;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.restaurant_item,parent,false);
        }
        TextView tv = convertView.findViewById(R.id.res_name);
        ImageView iv = convertView.findViewById(R.id.res_img);
        TextView str = convertView.findViewById(R.id.star_pnt);
        TextView work = convertView.findViewById(R.id.working);
        TextView minuate = convertView.findViewById(R.id.minuate);


        tv.setText(restaurant.getRes_name());
        int dr=getImg.getImg(restaurant.getRes_img());
        iv.setImageResource(dr);
        str.setText(String.valueOf(restaurant.getStar()));
        work.setText(String.valueOf(distance));
        work.append("m   ");
        minuate.setText(String.valueOf(minute));
        minuate.append("분");


        return convertView;
    }
}
