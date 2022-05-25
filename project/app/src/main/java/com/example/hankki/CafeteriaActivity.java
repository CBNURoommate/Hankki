package com.example.hankki;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class CafeteriaActivity extends AppCompatActivity {
    private HanbitFragment fragmentH;
    private ByeolbitFragment fragmentB;
    private EunhasuFragment fragmentE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeteria);

        RestaurantActivity.res_list.clear();

        fragmentH = new HanbitFragment();
        fragmentB = new ByeolbitFragment();
        fragmentE = new EunhasuFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentH).commit();

        // 식당 버튼
        Button hanbitBtn = (Button) findViewById(R.id.hanbitBtn);
        hanbitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentH).commit();
            }
        });
        Button byeolbitBtn = (Button) findViewById(R.id.byeolbitBtn);
        byeolbitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentB).commit();
            }
        });
        Button eunhasuBtn = (Button) findViewById(R.id.eunhasuBtn);
        eunhasuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentE).commit();
            }
        });

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
    public void onFragmentChange(int index){
        if (index == 0 ){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentB).commit();
        }else if (index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentE).commit();
        }else if (index == 2){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentE).commit();
        }
    }
}