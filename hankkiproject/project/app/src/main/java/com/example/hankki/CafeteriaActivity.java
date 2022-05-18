package com.example.hankki;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CafeteriaActivity extends AppCompatActivity {
    TextView textView;
    String url = "https://www.cbnucoop.com/service/restaurant/";
    String msg = "";

    final Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeteria);

        textView = (TextView) findViewById(R.id.res_text);

        new Thread(){
            @Override
            public void run(){
                Document document = null;

                try {
                    document = Jsoup.connect(url).get();
                    Elements element = document.select(".card-body li"); // 선택자 수정 필요 .card-body li
                    for(int i = 0; i < element.size(); i++){
                        msg += " " + element.get(i).text();
                    }
                    bundle.putString("result", msg);
                    Message msg = handler.obtainMessage();
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        // 하단바 버튼 기능
        ImageButton matchingBtn = (ImageButton) findViewById(R.id.matchingBtn);
        matchingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MatchingActivity.class);
                startActivity(intent);
            }
        });
        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        ImageButton restaurantBtn = (ImageButton) findViewById(R.id.restaurantBtn);
        restaurantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
                startActivity(intent);
            }
        });
        ImageButton personalBtn = (ImageButton) findViewById(R.id.personalBtn);
        personalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PersonalActivity.class);
                startActivity(intent);
            }
        });
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            Bundle bundle = msg.getData();
            textView.setText(bundle.getString("result"));
        }
    };
}