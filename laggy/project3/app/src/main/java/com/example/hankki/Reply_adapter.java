package com.example.hankki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Reply_adapter extends ArrayAdapter<Reply_class> {
    public Reply_adapter(Context context, int resource, List <Reply_class> reply_list){
        super(context, resource, reply_list);
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Reply_class reply = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.reply_item,parent,false);
        }


        TextView tv = convertView.findViewById(R.id.reply_name);
        TextView iv = convertView.findViewById(R.id.reply_context);

        tv.setText(reply.getName());
        iv.setText(reply.getContext());

        return convertView;
    }
}
