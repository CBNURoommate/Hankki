package com.example.hankki;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class EunhasuFragment<view> extends Fragment {
    final Bundle bundle = new Bundle();

    TextView textView, textView2, textView3, textView4;
    Element lunchA, dinnerA; Elements lunchB, dinnerB;
    String url = "https://www.cbnucoop.com/service/restaurant/";
    String lunchMain = ""; String lunchSide = "";
    String dinnerMain = ""; String dinnerSide = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eunhasu, container, false);

        textView = (TextView) view.findViewById(R.id.e_lunchMain);
        textView2 = (TextView) view.findViewById(R.id.e_lunchSide);
        textView3 = (TextView) view.findViewById(R.id.e_dinnerMain);
        textView4 = (TextView) view.findViewById(R.id.e_dinnerSide);

        lunchMain = ""; lunchSide = ""; dinnerMain = ""; dinnerSide = "";    // 식단표 초기화

        new Thread(){
            @Override
            public void run(){
                Document document = null;

                try {
                    document = Jsoup.connect(url).get();
                    switch(getCurrentWeek()){
                        case 2:
                            lunchA = document.select(".menu[data-table='20-6-12-0'] h6").first();
                            lunchB = document.select(".menu[data-table='20-6-12-0'] .side");
                            dinnerA = document.select(".menu[data-table='20-13-25-0'] h6").first();
                            dinnerB = document.select(".menu[data-table='20-13-25-0'] .side");
                            break;
                        case 3:
                            lunchA = document.select(".menu[data-table='20-6-12-1'] h6").first();
                            lunchB = document.select(".menu[data-table='20-6-12-1'] .side");
                            dinnerA = document.select(".menu[data-table='20-13-25-1'] h6").first();
                            dinnerB = document.select(".menu[data-table='20-13-25-1'] .side");
                            break;
                        case 4:
                            lunchA = document.select(".menu[data-table='20-6-12-2'] h6").first();
                            lunchB = document.select(".menu[data-table='20-6-12-2'] .side");
                            dinnerA = document.select(".menu[data-table='20-13-25-2'] h6").first();
                            dinnerB = document.select(".menu[data-table='20-13-25-2'] .side");
                            break;
                        case 5:
                            lunchA = document.select(".menu[data-table='20-6-12-3'] h6").first();
                            lunchB = document.select(".menu[data-table='20-6-12-3'] .side");
                            dinnerA = document.select(".menu[data-table='20-13-25-3'] h6").first();
                            dinnerB = document.select(".menu[data-table='20-13-25-3'] .side");
                            break;
                        case 6:
                            lunchA = document.select(".menu[data-table='20-6-12-4'] h6").first();
                            lunchB = document.select(".menu[data-table='20-6-12-4'] .side");
                            break;
                        default:
                            break;
                    }

                    if(lunchA != null) {
                        lunchMain += lunchA.text();
                    } else lunchMain = " ";
                    if(lunchB != null) {
                        for(int i = 0; i < lunchB.size(); i++){
                            lunchSide += lunchB.get(i).text() + " ";
                        }
                    } else lunchSide = " ";
                    if(dinnerA != null){
                        dinnerMain += dinnerA.text();
                    } else dinnerMain = " ";
                    if(dinnerB != null){
                        for(int i = 0; i < dinnerB.size(); i++){
                            dinnerSide += dinnerB.get(i).text() + " ";
                        }
                    } else dinnerSide = " ";

                    bundle.putString("lunchMain", lunchMain);
                    bundle.putString("lunchSide", lunchSide);
                    bundle.putString("dinnerMain", dinnerMain);
                    bundle.putString("dinnerSide", dinnerSide);
                    Message msg = handler.obtainMessage();
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        return view;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            Bundle bundle = msg.getData();
            textView.setText(bundle.getString("lunchMain"));
            textView2.setText(bundle.getString("lunchSide"));
            textView3.setText(bundle.getString("dinnerMain"));
            textView4.setText(bundle.getString("dinnerSide"));
        }
    };

    public static int getCurrentWeek() {
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        int dayOfWeekNumber = calendar.get(Calendar.DAY_OF_WEEK);

        return dayOfWeekNumber;
    }
}
