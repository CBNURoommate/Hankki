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

public class ByeolbitFragment extends Fragment {
    final Bundle bundle = new Bundle();

    TextView textView, textView2;
    Element lunchA; Elements lunchB;
    String url = "https://www.cbnucoop.com/service/restaurant/";
    String lunchMain = ""; String lunchSide = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_byeolbit, container, false);

        textView = (TextView) view.findViewById(R.id.b_lunchMain);
        textView2 = (TextView) view.findViewById(R.id.b_lunchSide);

        lunchMain = ""; lunchSide = ""; // 식단표 초기화

        new Thread(){
            @Override
            public void run(){
                Document document = null;

                try {
                    document = Jsoup.connect(url).get();
                    switch(getCurrentWeek()){
                        case 2:
                            lunchA = document.select(".menu[data-table='19-7-14-0'] h6").first();
                            lunchB = document.select(".menu[data-table='19-7-14-0'] .side");
                            break;
                        case 3:
                            lunchA = document.select(".menu[data-table='19-7-14-1'] h6").first();
                            lunchB = document.select(".menu[data-table='19-7-14-1'] .side");
                            break;
                        case 4:
                            lunchA = document.select(".menu[data-table='19-7-14-2'] h6").first();
                            lunchB = document.select(".menu[data-table='19-7-14-2'] .side");
                            break;
                        case 5:
                            lunchA = document.select(".menu[data-table='19-7-14-3'] h6").first();
                            lunchB = document.select(".menu[data-table='19-7-14-3'] .side");
                            break;
                        case 6:
                            lunchA = document.select(".menu[data-table='19-7-14-4'] h6").first();
                            lunchB = document.select(".menu[data-table='19-7-14-4'] .side");
                            break;
                        default:
                            break;
                    }

                    if(lunchA != null){
                        lunchMain += lunchA.text();
                    } else lunchMain = " ";
                    if(lunchB != null){
                        for(int i = 0; i < lunchB.size(); i++){
                            lunchSide += lunchB.get(i).text() + " ";
                        }
                    } else lunchSide = " ";

                    bundle.putString("lunchMain", lunchMain);
                    bundle.putString("lunchSide", lunchSide);
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
