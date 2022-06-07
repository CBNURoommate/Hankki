package com.example.hankki;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;


public class MatchingActivity extends FragmentActivity {

    public static ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);

        viewpager = findViewById(R.id.viewpager);

        viewpager.setOffscreenPageLimit(6);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        fragment_preference fragment0 = new fragment_preference();
        adapter.addItem(fragment0);

        fragment_spicy fragment1 = new fragment_spicy();
        adapter.addItem(fragment1);

        fragment_salty fragment5 =  new fragment_salty();
        adapter.addItem(fragment5);

        fragment_genre fragment2 = new fragment_genre();
        adapter.addItem(fragment2);

        fragment_ban fragment6 = new fragment_ban();
        adapter.addItem(fragment6);

        fragment_matching fragment3 = new fragment_matching();
        adapter.addItem(fragment3);



        viewpager.setAdapter(adapter);

        RestaurantActivity.res_list.clear();
        RestaurantActivity.budae_menu_list.clear();
        RestaurantActivity.cupo_menu_list.clear();
        RestaurantActivity.lotte_menu_list.clear();

        // 하단바 버튼 기능
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

    class MyPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        public Fragment getItem(int position){
            return items.get(position);
        }

        public int getCount(){
            return items.size();
        }

        public CharSequence getPageTitle(int position){
            return "페이지" + position;
        }


    }
}