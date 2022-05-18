package com.example.res_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.SearchView;


import java.util.ArrayList;

public class Restaurant extends AppCompatActivity  {
    // 식당 리스트 생성
    public static ArrayList <Res_class> res_list = new ArrayList<Res_class>();

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_main);

        search_res();

        setUpdata();

        setUpList();

        setUpOnclickListener();
    }

    // 식당 데이터 삽입 함수
    private void setUpdata(){

        Res_class budae = new Res_class("0","jungmin",R.drawable.budae,37.541,126.986);
        Res_class budae2 = new Res_class("1","dohyunm",R.drawable.ic_launcher_background,37.6411,126.986);
        Res_class budae3 = new Res_class("2","jungmin",R.drawable.budae,37.541,126.986);
        Res_class budae4 = new Res_class("3","jungmin",R.drawable.budae,37.541,126.986);
        Res_class budae5 = new Res_class("4","jungmin",R.drawable.budae,37.541,126.986);
        Res_class budae6 = new Res_class("5","jungmin",R.drawable.budae,37.541,126.986);
        Res_class budae7 = new Res_class("6","jungmin",R.drawable.budae,37.541,126.986);
        res_list.add(budae);
        res_list.add(budae2);
        res_list.add(budae3);
        res_list.add(budae4);
        res_list.add(budae5);
        res_list.add(budae6);
        res_list.add(budae7);
    }

    //리스트 셋업
    private void setUpList(){
        listView = findViewById(R.id.res_listView);

        //어댑터를 통하여
        Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0 , res_list);
        listView.setAdapter(adapter);
    }

    //검색창 구현
    private void search_res(){
        SearchView searchView = findViewById(R.id.res_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<Res_class> filterRes = new ArrayList<>();
                for (int i = 0; i< res_list.size(); i++){
                    Res_class res = res_list.get(i);

                    if(res.getRes_name().toLowerCase().contains(newText.toLowerCase())) {
                        filterRes.add(res);
                       }
                    }

                Res_Adapter adapter = new Res_Adapter(getApplicationContext(),0,filterRes);
                listView.setAdapter(adapter);
                return false;
            }
        });
    }

    //리스트의 아이템을 눌렀을때 식당 디테일 출력
    private void setUpOnclickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Res_class selectRestaurant = (Res_class) listView.getItemAtPosition(position);
                Intent showDetail = new Intent(getApplicationContext(), Res_Detail.class);
                showDetail.putExtra("id",selectRestaurant.getRes_id());
                startActivity(showDetail);
            }
        });
    }

}