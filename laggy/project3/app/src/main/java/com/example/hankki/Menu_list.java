package com.example.hankki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Menu_list extends AppCompatActivity  {
    // 식당 리스트 생성
    public static ArrayList <Res_class> res_list = new ArrayList<Res_class>();
    public static ArrayList<Menu_Class> menu_list=new ArrayList<>();


    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_list);

        getSelectedRestaurant();
        menu_list.clear();

        setUpdata();
        setUpList();

        search_res();

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
        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });
    }

    private void setUpdata() {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse= new JSONObject(response);
                    JSONArray jsonArray= jsonResponse.getJSONArray("response");
                    System.out.println(jsonArray);
                    for(int i=0;i<jsonArray.length();i++)
                    {

                        Menu_Class menu;
                        JSONObject item=jsonArray.getJSONObject(i);
                        menu=new Menu_Class(
                                item.getString("id"),
                                item.getString("name"),
                                item.getInt("img")
                        );

                        menu_list.add(menu);

                    }

                    search_res();
                    setUpList();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        MenuRequest menuRequest = new MenuRequest(Res_Detail.selectedRestaurant.getRes_id(),responseListener);
        RequestQueue queue = Volley.newRequestQueue(Menu_list.this);
        queue.add(menuRequest);

    }
    //리스트 셋업
    private void setUpList(){
        listView = findViewById(R.id.menu_listView);

        System.out.println("hi"+menu_list.size());
        //어댑터를 통하여
        com.example.hankki.Menu_Adapter adapter = new com.example.hankki.Menu_Adapter(getApplicationContext(), 0 , menu_list);
        listView.setAdapter(adapter);

    }


    private void getSelectedRestaurant() {

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        Res_Detail.selectedRestaurant = RestaurantActivity.res_list.get(Integer.valueOf(id));
    }

    private void getMenu(String id)
    {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse= new JSONObject(response);
                    JSONArray jsonArray= jsonResponse.getJSONArray("response");
                    System.out.println(jsonArray.length());
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        Menu_Class menu;
                        JSONObject item=jsonArray.getJSONObject(i);
                        menu=new Menu_Class(
                                item.getString("id"),
                                item.getString("name"),
                                item.getInt("img")
                        );

                        menu_list.add(menu);


                    }
                    System.out.println(menu_list.size());


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        MenuRequest menuRequest = new MenuRequest(id,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Menu_list.this);
        queue.add(menuRequest);


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
                for (int i = 0; i< Res_Detail.selectedRestaurant.menu_list.size(); i++){
                    Menu_Class menu = Res_Detail.selectedRestaurant.menu_list.get(i);

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

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.hold,R.anim.slide_out_right);
    }
}
