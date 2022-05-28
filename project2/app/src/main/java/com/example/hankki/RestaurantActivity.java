package com.example.hankki;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SearchView;


import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    public static ArrayList<Res_class> res_list = new ArrayList<Res_class>();
    public static ArrayList<Menu_Class> budae_menu_list = new ArrayList<>();
    public static ArrayList<Menu_Class> lotte_menu_list = new ArrayList<>();
    public static ArrayList<Menu_Class> cupo_menu_list = new ArrayList<>();
    User_Class user = new User_Class("id", "1234", "이상호", 1, 0, 37.6410, 126.980);

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        search_res();

        setUpdata();

        setUpList();

        setUpOnclickListener();

        check_option();


        // 하단바 버튼 기능
        ImageButton matchingBtn = (ImageButton) findViewById(R.id.matchingBtn);
        matchingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MatchingActivity.class);
                startActivity(intent);
            }
        });
        ImageButton cafeteriaBtn = (ImageButton) findViewById(R.id.cafeteriaBtn);
        cafeteriaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CafeteriaActivity.class);
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
        ImageButton personalBtn = (ImageButton) findViewById(R.id.personalBtn);
        personalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PersonalActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setUpdata() {

        Menu_Class budae_menu = new Menu_Class(1, "부대찌개", R.drawable.budae);
        Menu_Class budae_menu2 = new Menu_Class(1, "제육볶음", R.drawable.budae);
        budae_menu_list.add(budae_menu);
        budae_menu_list.add(budae_menu2);
        Res_class budae = new Res_class("0", "부대통령 부대찌개", R.drawable.budae, 37.541, 126.986, 1, 0, budae_menu_list,3.5F);
        res_list.add(budae);

        Menu_Class lotte_menu = new Menu_Class(1, "데리버거", R.drawable.budae);
        Menu_Class lotte_menu2 = new Menu_Class(1, "치즈버거", R.drawable.budae);
        lotte_menu_list.add(lotte_menu);
        lotte_menu_list.add(lotte_menu2);
        Res_class lotte = new Res_class("1", "롯데리아", R.drawable.lotte, 0, 126.986, 3, 0, lotte_menu_list,4.5F);
        res_list.add(lotte);

        Menu_Class cupo_menu = new Menu_Class(1, "두루치기", R.drawable.budae);
        Menu_Class cupo_menu2 = new Menu_Class(1, "순대국밥", R.drawable.budae);
        cupo_menu_list.add(cupo_menu);
        cupo_menu_list.add(cupo_menu2);
        Res_class cupo = new Res_class("2", "추억의 포장마차", R.drawable.ic_launcher_background, 37.6411, 126.986, 2, 1, cupo_menu_list, 2.5F);
        res_list.add(cupo);
        res_list.add(cupo);
        res_list.add(cupo);
        res_list.add(cupo);
        res_list.add(cupo);
        res_list.add(cupo);
        res_list.add(cupo);

        //User_Class user = new User_Class("id","1234","이상호",1,0,37.6410,126.980);
    }

    //리스트 셋업
    private void setUpList() {
        listView = findViewById(R.id.res_listView);

        //어댑터를 통하여
        Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list);
        listView.setAdapter(adapter);
    }

    //검색창 구현
    private void search_res() {
        SearchView searchView = findViewById(R.id.res_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<Res_class> filterRes = new ArrayList<>();
                for (int i = 0; i < res_list.size(); i++) {
                    Res_class res = res_list.get(i);

                    if (res.getRes_name().toLowerCase().contains(newText.toLowerCase())) {
                        filterRes.add(res);
                    }
                }

                Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes);
                listView.setAdapter(adapter);
                return false;
            }
        });
    }

    //리스트의 아이템을 눌렀을때 식당 디테일 출력
    private void setUpOnclickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Res_class selectRestaurant = (Res_class) listView.getItemAtPosition(position);
                Intent showDetail = new Intent(getApplicationContext(), Res_Detail.class);
                showDetail.putExtra("id", selectRestaurant.getRes_id());
                startActivity(showDetail);
            }
        });
    }

    private void check_option(){

        Button find_btn = findViewById(R.id.find_btn);

        CheckBox check_dist = (CheckBox) findViewById(R.id.check_dist);
        CheckBox check_star = findViewById(R.id.check_star);
        CheckBox kor = findViewById(R.id.kor_genre);
        CheckBox chn = findViewById(R.id.chn_genre);
        CheckBox usa = findViewById(R.id.usa_genre);


        find_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kor.setChecked(false);
                chn.setChecked(false);
                usa.setChecked(false);
                check_star.setChecked(false);
                check_dist.setChecked(false);
                kor.setBackgroundResource(R.color.white);
                chn.setBackgroundResource(R.color.white);
                usa.setBackgroundResource(R.color.white);
                check_star.setBackgroundResource(R.color.white);
                check_dist.setBackgroundResource(R.color.white);


                Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list);
                listView.setAdapter(adapter);

            }
        });

        kor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Res_class> filterRes = new ArrayList<>();
                if(kor.isChecked()){
                    kor.setBackgroundResource(R.drawable.backgrouder);
                    chn.setChecked(false);
                    usa.setChecked(false);
                    check_star.setChecked(false);
                    check_dist.setChecked(false);
                    chn.setBackgroundResource(R.color.white);
                    usa.setBackgroundResource(R.color.white);
                    check_star.setBackgroundResource(R.color.white);
                    check_dist.setBackgroundResource(R.color.white);
                    for (int i = 0; i < res_list.size(); i++) {
                        Res_class res = res_list.get(i);
                        if (res.getGenre() == 1)
                            filterRes.add(res);
                    }
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes);
                    listView.setAdapter(adapter);
                }
                else{
                    kor.setBackgroundResource(R.color.white);
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list);
                    listView.setAdapter(adapter);
                }
            }
        });



        chn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Res_class> filterRes = new ArrayList<>();
                if(chn.isChecked()){
                    chn.setBackgroundResource(R.drawable.backgrouder);
                    kor.setChecked(false);
                    usa.setChecked(false);
                    check_star.setChecked(false);
                    kor.setBackgroundResource(R.color.white);
                    usa.setBackgroundResource(R.color.white);
                    check_star.setBackgroundResource(R.color.white);
                    for (int i = 0; i < res_list.size(); i++) {
                        Res_class res = res_list.get(i);
                        if (res.getGenre() == 2)
                            filterRes.add(res);
                    }
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes);
                    listView.setAdapter(adapter);
                }
                else{
                    chn.setBackgroundResource(R.color.white);
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list);
                    listView.setAdapter(adapter);
                }
            }
        });

        usa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Res_class> filterRes = new ArrayList<>();
                if(usa.isChecked()){
                    usa.setBackgroundResource(R.drawable.backgrouder);
                    kor.setChecked(false);
                    chn.setChecked(false);
                    check_star.setChecked(false);
                    kor.setBackgroundResource(R.color.white);
                    chn.setBackgroundResource(R.color.white);
                    check_star.setBackgroundResource(R.color.white);
                    for (int i = 0; i < res_list.size(); i++) {
                        Res_class res = res_list.get(i);
                        if (res.getGenre() == 3)
                            filterRes.add(res);
                    }
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes);
                    listView.setAdapter(adapter);
                }
                else{
                    usa.setBackgroundResource(R.color.white);
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list);
                    listView.setAdapter(adapter);
                }
            }
        });


        check_star.setOnClickListener(new View.OnClickListener() {
            Res_class arr[] = new Res_class[res_list.size()];
            ArrayList<Res_class> filterRes = new ArrayList<>();

            @Override
            public void onClick(View v) {
                if (check_star.isChecked()) {
                    check_star.setBackgroundResource(R.drawable.backgrouder);
                    kor.setChecked(false);
                    chn.setChecked(false);
                    usa.setChecked(false);
                    check_dist.setChecked(false);
                    kor.setBackgroundResource(R.color.white);
                    chn.setBackgroundResource(R.color.white);
                    usa.setBackgroundResource(R.color.white);
                    check_dist.setBackgroundResource(R.color.white);
                    for (int i = 0; i < res_list.size(); i++) {
                        Res_class res = res_list.get(i);
                        arr[i] = res;
                    }

                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr.length - i - 1; j++) {
                            if (arr[j].getStar() <= arr[j + 1].getStar()) {
                                Res_class temp = arr[j + 1];
                                arr[j + 1] = arr[j];
                                arr[j] = temp;
                            }
                        }
                    }

                    for (int i = 0; i < arr.length; i++) {
                        filterRes.add(arr[i]);
                    }

                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes);
                    listView.setAdapter(adapter);


                }
                else{
                    check_star.setBackgroundResource(R.color.white);
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list);
                    listView.setAdapter(adapter);
                }
            }
        });

        check_dist.setOnClickListener(new View.OnClickListener() {
            Res_class arr[] = new Res_class[res_list.size()];
            ArrayList<Res_class> filterRes = new ArrayList<>();

            @Override
            public void onClick(View v) {
                if (check_dist.isChecked()) {
                    check_dist.setBackgroundResource(R.drawable.backgrouder);
                    kor.setChecked(false);
                    chn.setChecked(false);
                    usa.setChecked(false);
                    check_star.setChecked(false);
                    kor.setBackgroundResource(R.color.white);
                    chn.setBackgroundResource(R.color.white);
                    usa.setBackgroundResource(R.color.white);
                    check_star.setBackgroundResource(R.color.white);
                    for (int i = 0; i < res_list.size(); i++) {
                        Res_class res = res_list.get(i);
                        arr[i] = res;
                    }

                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr.length - i - 1; j++) {
                            if (arr[j].getLatitude() <= arr[j + 1].getLatitude()) {
                                Res_class temp = arr[j + 1];
                                arr[j + 1] = arr[j];
                                arr[j] = temp;
                            }
                        }
                    }

                    for (int i = 0; i < arr.length; i++) {
                        filterRes.add(arr[i]);
                    }

                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes);
                    listView.setAdapter(adapter);


                }
                else{
                    check_dist.setBackgroundResource(R.color.white);
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list);
                    listView.setAdapter(adapter);
                }
            }
        });


    }

}