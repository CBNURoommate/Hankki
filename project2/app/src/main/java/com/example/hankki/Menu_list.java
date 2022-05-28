package com.example.hankki;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Menu_list extends AppCompatActivity  {
    // 식당 리스트 생성
    public static ArrayList <Res_class> res_list = new ArrayList<Res_class>();

    Res_class selectedRestaurant;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_list);

        getSelectedRestaurant();

        setUpList();

        search_res();

    }


    //리스트 셋업
    private void setUpList(){
        listView = findViewById(R.id.menu_listView);

        //어댑터를 통하여
        com.example.hankki.Menu_Adapter adapter = new com.example.hankki.Menu_Adapter(getApplicationContext(), 0 , selectedRestaurant.getMenu_list());
        listView.setAdapter(adapter);
    }


    private void getSelectedRestaurant() {

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        selectedRestaurant = RestaurantActivity.res_list.get(Integer.valueOf(id));
    }

    private void search_res(){
        SearchView searchView = findViewById(R.id.menu_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<Menu_Class> filterRes = new ArrayList<>();
                for (int i = 0; i< selectedRestaurant.menu_list.size(); i++){
                    Menu_Class menu = selectedRestaurant.menu_list.get(i);

                    if(menu.getName().toLowerCase().contains(newText.toLowerCase())) {
                        filterRes.add(menu);
                    }
                }

                com.example.hankki.Menu_Adapter adapter = new com.example.hankki.Menu_Adapter(getApplicationContext(),0,filterRes);
                listView.setAdapter(adapter);
                return false;
            }
        });
    }


}