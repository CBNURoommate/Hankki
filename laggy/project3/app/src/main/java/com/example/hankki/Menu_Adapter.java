package com.example.hankki;

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

public class Menu_Adapter extends ArrayAdapter<Menu_Class> {
    public Menu_Adapter(Context context, int resource, List <Menu_Class> menu_list){
        super(context, resource, menu_list);
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Menu_Class restaurant = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_item,parent,false);
        }
        TextView tv = convertView.findViewById(R.id.menu_name);
        ImageView iv = convertView.findViewById(R.id.menu_img);

        tv.setText(restaurant.getName());
        int dr=getImg.getImg(restaurant.getImg());
        iv.setImageResource(dr);

        return convertView;
    }
}
