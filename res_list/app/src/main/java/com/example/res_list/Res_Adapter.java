package com.example.res_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Res_Adapter extends ArrayAdapter<Res_class> {
    public Res_Adapter(Context context, int resource, List <Res_class> Res_list){
        super(context, resource, Res_list);
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Res_class restaurant = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.restaurant_item,parent,false);
        }
        TextView tv = convertView.findViewById(R.id.res_name);
        ImageView iv = convertView.findViewById(R.id.res_img);

        tv.setText(restaurant.getRes_name());
        iv.setImageResource(restaurant.getRes_img());

        return convertView;
    }
}
