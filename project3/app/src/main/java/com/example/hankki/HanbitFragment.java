package com.example.hankki;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

public class HanbitFragment extends Fragment {
    final Bundle bundle = new Bundle();

    TextView textView, textView2, textView3, textView4, textView5, textView6;
    Element brunchA, lunchA, dinnerA; Elements brunchB, lunchB, dinnerB;
    String url = "https://www.cbnucoop.com/service/restaurant/";
    String brunchMain = ""; String brunchSide = "";
    String lunchMain = ""; String lunchSide = "";
    String dinnerMain = ""; String dinnerSide = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hanbit, container, false);

        textView = (TextView) view.findViewById(R.id.h_brunchMain);
        textView2 = (TextView) view.findViewById(R.id.h_brunchSide);
        textView3 = (TextView) view.findViewById(R.id.h_lunchMain);
        textView4 = (TextView) view.findViewById(R.id.h_lunchSide);
        textView5 = (TextView) view.findViewById(R.id.h_dinnerMain);
        textView6 = (TextView) view.findViewById(R.id.h_dinnerSide);

        brunchMain = ""; brunchSide = ""; lunchMain = ""; lunchSide = "";   // 식단표 초기화

        new Thread(){
            @Override
            public void run(){
                Document document = null;

                try {
                    document = Jsoup.connect(url).get();
                    switch(getCurrentWeek()){
                        case 2:
                            brunchA = document.select(".menu[data-table='18-9-17-0'] h6").first();
                            brunchB = document.select(".menu[data-table='18-9-17-0'] .side");
                            lunchA = document.select(".menu[data-table='18-8-16-0'] h6").first();
                            lunchB = document.select(".menu[data-table='18-8-16-0'] .side");
                            dinnerA = document.select(".menu[data-table='18-10-18-0'] h6").first();
                            dinnerB = document.select(".menu[data-table='18-10-18-0'] .side");
                            break;
                        case 3:
                            brunchA = document.select(".menu[data-table='18-9-17-1'] h6").first();
                            brunchB = document.select(".menu[data-table='18-9-17-1'] .side");
                            lunchA = document.select(".menu[data-table='18-8-16-1'] h6").first();
                            lunchB = document.select(".menu[data-table='18-8-16-1'] .side");
                            dinnerA = document.select(".menu[data-table='18-10-18-1'] h6").first();
                            dinnerB = document.select(".menu[data-table='18-10-18-1'] .side");
                            break;
                        case 4:
                            brunchA = document.select(".menu[data-table='18-9-17-2'] h6").first();
                            brunchB = document.select(".menu[data-table='18-9-17-2'] .side");
                            lunchA = document.select(".menu[data-table='18-8-16-2'] h6").first();
                            lunchB = document.select(".menu[data-table='18-8-16-2'] .side");
                            dinnerA = document.select(".menu[data-table='18-10-18-2'] h6").first();
                            dinnerB = document.select(".menu[data-table='18-10-18-2'] .side");
                            break;
                        case 5:
                            brunchA = document.select(".menu[data-table='18-9-17-3'] h6").first();
                            brunchB = document.select(".menu[data-table='18-9-17-3'] .side");
                            lunchA = document.select(".menu[data-table='18-8-16-3'] h6").first();
                            lunchB = document.select(".menu[data-table='18-8-16-3'] .side");
                            dinnerA = document.select(".menu[data-table='18-10-18-3'] h6").first();
                            dinnerB = document.select(".menu[data-table='18-10-18-3'] .side");
                            break;
                        case 6:
                            brunchA = document.select(".menu[data-table='18-9-17-4'] h6").first();
                            brunchB = document.select(".menu[data-table='18-9-17-4'] .side");
                            lunchA = document.select(".menu[data-table='18-8-16-4'] h6").first();
                            lunchB = document.select(".menu[data-table='18-8-16-4'] .side");
                            dinnerA = document.select(".menu[data-table='18-10-18-4'] h6").first();
                            dinnerB = document.select(".menu[data-table='18-10-18-4'] .side");
                            break;
                        default:
                            break;
                    }

                    if(brunchA != null){
                        brunchMain = brunchA.text();
                    } else brunchMain = " ";
                    if(brunchB != null){
                        for(int i = 0; i < brunchB.size(); i++){
                            brunchSide += brunchB.get(i).text() + " ";
                        }
                    } else brunchSide = " ";
                    if(lunchA != null){
                        lunchMain += lunchA.text();
                    } else lunchMain = " ";
                    if(lunchB != null){
                        for(int i = 0; i < lunchB.size(); i++){
                            lunchSide += lunchB.get(i).text() + " ";
                        }
                    } else lunchSide = " ";
                    if(dinnerA != null){
                        dinnerMain = dinnerA.text();
                    } else dinnerMain = " ";
                    if(dinnerB != null){
                        for(int i = 0; i < dinnerB.size(); i++){
                            dinnerSide += dinnerB.get(i).text() + " ";
                        }
                    } else dinnerSide = " ";

                    bundle.putString("brunchMain", brunchMain);
                    bundle.putString("brunchSide", brunchSide);
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
            textView.setText(bundle.getString("brunchMain"));
            textView2.setText(bundle.getString("brunchSide"));
            textView3.setText(bundle.getString("lunchMain"));
            textView4.setText(bundle.getString("lunchSide"));
            textView5.setText(bundle.getString("dinnerMain"));
            textView6.setText(bundle.getString("dinnerSide"));
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
