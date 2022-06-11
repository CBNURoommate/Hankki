package com.example.hankki;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class PersonalActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        RestaurantActivity.res_list.clear();

        TextView spicyText = findViewById(R.id.spicyText);
        TextView genreText = findViewById(R.id.genreText);
        TextView saltyText = findViewById(R.id.saltyText);
        TextView seaText = findViewById(R.id.seaText);
        TextView mushText = findViewById(R.id.mushText);
        TextView cucumText = findViewById(R.id.cucumText);
        TextView gosuText = findViewById(R.id.gosuText);
        TextView gutText = findViewById(R.id.gutText);

        spicyText.setText(String.valueOf(RestaurantActivity.user.getSpicy()));
        saltyText.setText(String.valueOf(RestaurantActivity.user.getSalty()));
        switch(String.valueOf(RestaurantActivity.user.getGenre())){
            case "1":
                genreText.setText("한식");
                break;
            case "2":
                genreText.setText("중식");
                break;
            case "3":
                genreText.setText("양식");
                break;
            case "4":
                genreText.setText("일식");
                break;
            case "5":
                genreText.setText("분식");
                break;
            default:
                genreText.setText("전체");
                break;
        }
        switch(String.valueOf(RestaurantActivity.user.getSea())){
            case "1":
                seaText.setText("불가");
                break;
            default:
                seaText.setText("가능");
                break;
        }
        switch(String.valueOf(RestaurantActivity.user.getMush())){
            case "1":
                mushText.setText("불가");
                break;
            default:
                mushText.setText("가능");
                break;
        }
        switch(String.valueOf(RestaurantActivity.user.getCucum())){
            case "1":
                cucumText.setText("불가");
                break;
            default:
                cucumText.setText("가능");
                break;
        }
        switch(String.valueOf(RestaurantActivity.user.getGosu())){
            case "1":
                gosuText.setText("불가");
                break;
            default:
                gosuText.setText("가능");
                break;
        }
        switch(String.valueOf(RestaurantActivity.user.getGut())){
            case "1":
                gutText.setText("불가");
                break;
            default:
                gutText.setText("가능");
                break;
        }

        // 하단바 버튼 기능
        ImageButton matchingBtn = (ImageButton) findViewById(R.id.matchingBtn);
        matchingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MatchingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });
        ImageButton cafeteriaBtn = (ImageButton) findViewById(R.id.cafeteriaBtn);
        cafeteriaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CafeteriaActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });
        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });
        ImageButton restaurantBtn = (ImageButton) findViewById(R.id.restaurantBtn);
        restaurantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });
    }

}