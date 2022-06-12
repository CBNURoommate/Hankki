package com.example.hankki;

import static androidx.annotation.InspectableProperty.ValueType.GRAVITY;

import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ViewFlipper v_fllipper, v_fllipper_2, v_fllipper_3;
    ViewFlipper vt_fllipper, vt_fllipper_2, vt_fllipper_3;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestaurantActivity.res_list.clear();
        RestaurantActivity.menu_list.clear();


        // 이미지 슬라이드
        int images[] = {
                R.drawable.banish_burger,
                R.drawable.cook_messiah,
                R.drawable.hangpoke
        };
        String texts[] = {
                "바니시버거", "쿡메시야", "행포케"
        };
        v_fllipper = findViewById(R.id.image_slide);
        vt_fllipper = findViewById(R.id.text_slide);
        for(int image : images) {
            fllipperImages(v_fllipper, image, 4500);
        }
        for(String text : texts){
            fllipperText(vt_fllipper, text, 4500, 20);
        }

        int images_2[] = {
                R.drawable.huyu,
                R.drawable.pizzawave
        };
        String texts_2[] = {
                "후유", "피자웨이브"
        };
        v_fllipper_2 = findViewById(R.id.image_slide_2);
        vt_fllipper_2 = findViewById(R.id.text_slide_2);
        for(int image_2 : images_2) {
            fllipperImages(v_fllipper_2, image_2, 3500);
        }
        for(String text_2 : texts_2){
            fllipperText(vt_fllipper_2, text_2, 3500, 16);
        }

        int images_3[] = {
                R.drawable.outdark,
                R.drawable.ujusikdang
        };
        String texts_3[] = {
                "아웃닭", "우주식당"
        };
        v_fllipper_3 = findViewById(R.id.image_slide_3);
        vt_fllipper_3 = findViewById(R.id.text_slide_3);
        for(int image_3 : images_3) {
            fllipperImages(v_fllipper_3, image_3, 3500);
        }
        for(String text_3 : texts_3){
            fllipperText(vt_fllipper_3, text_3, 3500, 16);
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
        ImageButton restaurantBtn = (ImageButton) findViewById(R.id.restaurantBtn);
        restaurantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });
        ImageButton personalBtn = (ImageButton) findViewById(R.id.personalBtn);
        personalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PersonalActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });

    }

    public void fllipperImages(ViewFlipper vf, int image, int delay) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        vf.addView(imageView);      // 이미지 추가
        vf.setFlipInterval(delay);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        vf.setAutoStart(true);          // 자동 시작 유무 설정

        vf.setInAnimation(this,android.R.anim.slide_in_left);
        vf.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    public void fllipperText(ViewFlipper vf, String text, int delay, int text_size) {
        TextView textView = new TextView(this);
        textView.setText(text);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) { // 폰트 설정
            Typeface typeface = getResources().getFont(R.font.font);
            textView.setTypeface(typeface, Typeface.BOLD);
        }
        textView.setTextSize(text_size);
        textView.setTextColor(Color.WHITE);
        textView.setGravity(Gravity.BOTTOM);
        vf.addView(textView);      // 이미지 추가
        vf.setFlipInterval(delay);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        vf.setAutoStart(true);          // 자동 시작 유무 설정

        vf.setInAnimation(this,android.R.anim.slide_in_left);
        vf.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}