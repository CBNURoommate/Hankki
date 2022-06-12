package com.example.hankki;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
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
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RestaurantActivity extends AppCompatActivity {

    public static ArrayList<Res_class> res_list = new ArrayList<Res_class>();
    public static ArrayList<Menu_Class> menu_list = new ArrayList<>();

    public static User_Class user = new User_Class("id", "1234", "이상호", 37.6412, 126.982);


    public static ListView listView;
    void updatePre() {
        ((nowMember) getApplication()).setGenre(user.getGenre());
        ((nowMember) getApplication()).setSalty(user.getSalty());
        ((nowMember) getApplication()).setSpicy(user.getSpicy());
        ((nowMember) getApplication()).setSea(user.getSea());
        ((nowMember) getApplication()).setMush(user.getMush());
        ((nowMember) getApplication()).setCucum(user.getCucum());
        ((nowMember) getApplication()).setGosu(user.getGosu());
        ((nowMember) getApplication()).setGut(user.getGut());


        Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        if (success) {
                            return;
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
            };

            PreRequest preRequest = new PreRequest(
                    user.getGenre(),
                    user.getSpicy(),
                    user.getSalty(),
                    user.getSea(),
                    user.getMush(),
                    user.getCucum(),
                    user.getGosu(),
                    user.getGut(),
                    ((nowMember) getApplication()).getId(),
                    responseListener);
            RequestQueue queue = Volley.newRequestQueue(RestaurantActivity.this);
            queue.add(preRequest);
        }

    void GPS()
    {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location loc_cur = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        ((nowMember)getApplication()).setLatitude(loc_cur.getLatitude());
        ((nowMember)getApplication()).setLongitude(loc_cur.getLongitude());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);



        setUpdata();
        if(((nowMember)getApplication()).getId()!=null)
            updatePre();
        GPS();

        search_res();

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

    public void setUpdata() {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse= new JSONObject(response);
                    JSONArray jsonArray= jsonResponse.getJSONArray("response");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        Res_class res;
                        ArrayList<Menu_Class> mlist=new ArrayList<>();
                        JSONObject item=jsonArray.getJSONObject(i);

                        res=new Res_class(
                                item.getString("Res_id"),
                                item.getString("Res_name"),
                                item.getInt("Res_img"),
                                item.getDouble("latitude"),
                                item.getDouble("longitude"),
                                item.getString("Res_address"),
                                item.getInt("gerne"),
                                item.getInt("spicy"),
                                item.getInt("salty"),
                                item.getInt("sea"),
                                item.getInt("mush"),
                                item.getInt("cucum"),
                                item.getInt("gosu"),
                                item.getInt("gut"),
                                (float) item.getDouble("star")
                        );

                        res_list.add(res);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RestRequest restRequest = new RestRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(RestaurantActivity.this);
        queue.add(restRequest);


    }

    //리스트 셋업
    private void setUpList() {
        listView = findViewById(R.id.res_listView);

        //어댑터를 통하여
        Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list,((nowMember)getApplication() ));
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

                Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes,(nowMember) getApplication());
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
                overridePendingTransition(R.anim.slide_in_right, R.anim.hold);
            }
        });
    }

    private void check_option(){

        Button reset_btn = findViewById(R.id.reset_btn);
        Button mylist_btn = findViewById(R.id.mylist);

        CheckBox check_dist = (CheckBox) findViewById(R.id.check_dist);
        CheckBox check_star = findViewById(R.id.check_star);
        CheckBox kor = findViewById(R.id.kor_genre);
        CheckBox chn = findViewById(R.id.chn_genre);
        CheckBox usa = findViewById(R.id.usa_genre);
        CheckBox jpn = findViewById(R.id.jpn_genre);
        CheckBox snack = findViewById(R.id.snack_genre);


        mylist_btn.setOnClickListener(new View.OnClickListener() { //초기화 버튼
            @Override
            public void onClick(View v) {
                ArrayList<Res_class> filterRes = new ArrayList<>();
                updatePre();
                kor.setChecked(false);
                chn.setChecked(false);
                usa.setChecked(false);
                jpn.setChecked(false);
                snack.setChecked(false);
                check_star.setChecked(false);
                check_dist.setChecked(false);
                kor.setBackgroundResource(R.color.white);
                kor.setTextColor(Color.parseColor("#000000"));
                chn.setBackgroundResource(R.color.white);
                chn.setTextColor(Color.parseColor("#000000"));
                usa.setBackgroundResource(R.color.white);
                usa.setTextColor(Color.parseColor("#000000"));
                jpn.setBackgroundResource(R.color.white);
                jpn.setTextColor(Color.parseColor("#000000"));
                snack.setBackgroundResource(R.color.white);
                snack.setTextColor(Color.parseColor("#000000"));
                check_star.setBackgroundResource(R.color.white);
                check_star.setTextColor(Color.parseColor("#000000"));
                check_dist.setBackgroundResource(R.color.white);
                check_dist.setTextColor(Color.parseColor("#000000"));


                System.out.println(res_list.size());

                for(int i = 0 ; i < res_list.size(); i++){
                    Res_class res = res_list.get(i);
                    System.out.println(res.getGenre());
                    if(res.getGenre() == ((nowMember)getApplication()).getGenre()) { //음식 장르 결정권
                      //if(res.getSpicy() <= ((nowMember)getApplication()).getSpicy())
                        //if(res.getSalty() == ((nowMember)getApplication()).getSalty())
                            //if((res.getSea() != ((nowMember)getApplication()).getSea()) && (res.getMush() != ((nowMember)getApplication()).getMush()) && res.getCucum() != ((nowMember)getApplication()).getCucum() && res.getGosu() != ((nowMember)getApplication()).getGosu() && res.getGut() != ((nowMember)getApplication()).getGut())
                                 filterRes.add(res);
                   }
                }

                System.out.println("hi"+filterRes.size());

                Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes,(nowMember) getApplication());
                listView.setAdapter(adapter);
            }
        });




        reset_btn.setOnClickListener(new View.OnClickListener() { //초기화 버튼
            @Override
            public void onClick(View v) {

                kor.setChecked(false);
                chn.setChecked(false);
                usa.setChecked(false);
                jpn.setChecked(false);
                snack.setChecked(false);
                check_star.setChecked(false);
                check_dist.setChecked(false);
                kor.setBackgroundResource(R.color.white);
                kor.setTextColor(Color.parseColor("#000000"));
                chn.setBackgroundResource(R.color.white);
                chn.setTextColor(Color.parseColor("#000000"));
                usa.setBackgroundResource(R.color.white);
                usa.setTextColor(Color.parseColor("#000000"));
                jpn.setBackgroundResource(R.color.white);
                jpn.setTextColor(Color.parseColor("#000000"));
                snack.setBackgroundResource(R.color.white);
                snack.setTextColor(Color.parseColor("#000000"));
                check_star.setBackgroundResource(R.color.white);
                check_star.setTextColor(Color.parseColor("#000000"));
                check_dist.setBackgroundResource(R.color.white);
                check_dist.setTextColor(Color.parseColor("#000000"));



                Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list,(nowMember) getApplication());
                listView.setAdapter(adapter);
            }
        });

        kor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Res_class> filterRes = new ArrayList<>();
                if(kor.isChecked()){
                    kor.setBackgroundResource(R.drawable.backgrouder);
                    kor.setTextColor(Color.parseColor("#ffffff"));
                    chn.setChecked(false);
                    usa.setChecked(false);
                    jpn.setChecked(false);
                    snack.setChecked(false);
                    check_star.setChecked(false);
                    check_dist.setChecked(false);
                    chn.setBackgroundResource(R.color.white);
                    chn.setTextColor(Color.parseColor("#000000"));
                    usa.setBackgroundResource(R.color.white);
                    usa.setTextColor(Color.parseColor("#000000"));
                    jpn.setBackgroundResource(R.color.white);
                    jpn.setTextColor(Color.parseColor("#000000"));
                    snack.setBackgroundResource(R.color.white);
                    snack.setTextColor(Color.parseColor("#000000"));
                    check_star.setBackgroundResource(R.color.white);
                    check_star.setTextColor(Color.parseColor("#000000"));
                    check_dist.setBackgroundResource(R.color.white);
                    check_dist.setTextColor(Color.parseColor("#000000"));
                    for (int i = 0; i < res_list.size(); i++) {
                        Res_class res = res_list.get(i);
                        if (res.getGenre() == 1)
                            filterRes.add(res);
                    }
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes,(nowMember) getApplication());
                    listView.setAdapter(adapter);
                }
                else{
                    kor.setBackgroundResource(R.color.white);
                    kor.setTextColor(Color.parseColor("#000000"));
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list,(nowMember) getApplication());
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
                    chn.setTextColor(Color.parseColor("#ffffff"));
                    kor.setChecked(false);
                    usa.setChecked(false);
                    jpn.setChecked(false);
                    snack.setChecked(false);
                    check_star.setChecked(false);
                    check_dist.setChecked(false);
                    kor.setBackgroundResource(R.color.white);
                    kor.setTextColor(Color.parseColor("#000000"));
                    usa.setBackgroundResource(R.color.white);
                    usa.setTextColor(Color.parseColor("#000000"));
                    jpn.setBackgroundResource(R.color.white);
                    jpn.setTextColor(Color.parseColor("#000000"));
                    snack.setBackgroundResource(R.color.white);
                    snack.setTextColor(Color.parseColor("#000000"));
                    check_star.setBackgroundResource(R.color.white);
                    check_star.setTextColor(Color.parseColor("#000000"));
                    check_dist.setBackgroundResource(R.color.white);
                    check_dist.setTextColor(Color.parseColor("#000000"));
                    for (int i = 0; i < res_list.size(); i++) {
                        Res_class res = res_list.get(i);
                        if (res.getGenre() == 2)
                            filterRes.add(res);
                    }
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes,(nowMember) getApplication());
                    listView.setAdapter(adapter);
                }
                else{
                    chn.setBackgroundResource(R.color.white);
                    chn.setTextColor(Color.parseColor("#000000"));
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list,(nowMember) getApplication());
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
                    usa.setTextColor(Color.parseColor("#ffffff"));
                    kor.setChecked(false);
                    chn.setChecked(false);
                    jpn.setChecked(false);
                    snack.setChecked(false);
                    check_star.setChecked(false);
                    check_dist.setChecked(false);
                    kor.setBackgroundResource(R.color.white);
                    kor.setTextColor(Color.parseColor("#000000"));
                    chn.setBackgroundResource(R.color.white);
                    chn.setTextColor(Color.parseColor("#000000"));
                    jpn.setBackgroundResource(R.color.white);
                    jpn.setTextColor(Color.parseColor("#000000"));
                    snack.setBackgroundResource(R.color.white);
                    snack.setTextColor(Color.parseColor("#000000"));
                    check_star.setBackgroundResource(R.color.white);
                    check_star.setTextColor(Color.parseColor("#000000"));
                    check_dist.setBackgroundResource(R.color.white);
                    check_dist.setTextColor(Color.parseColor("#000000"));
                    for (int i = 0; i < res_list.size(); i++) {
                        Res_class res = res_list.get(i);
                        if (res.getGenre() == 3)
                            filterRes.add(res);
                    }
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes,(nowMember) getApplication());
                    listView.setAdapter(adapter);
                }
                else{
                    usa.setBackgroundResource(R.color.white);
                    usa.setTextColor(Color.parseColor("#000000"));
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list,(nowMember) getApplication());
                    listView.setAdapter(adapter);
                }
            }
        });

        jpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Res_class> filterRes = new ArrayList<>();
                if(jpn.isChecked()){
                    jpn.setBackgroundResource(R.drawable.backgrouder);
                    jpn.setTextColor(Color.parseColor("#ffffff"));
                    kor.setChecked(false);
                    chn.setChecked(false);
                    usa.setChecked(false);
                    snack.setChecked(false);
                    check_star.setChecked(false);
                    check_dist.setChecked(false);
                    kor.setBackgroundResource(R.color.white);
                    kor.setTextColor(Color.parseColor("#000000"));
                    chn.setBackgroundResource(R.color.white);
                    chn.setTextColor(Color.parseColor("#000000"));
                    usa.setBackgroundResource(R.color.white);
                    usa.setTextColor(Color.parseColor("#000000"));
                    snack.setBackgroundResource(R.color.white);
                    snack.setTextColor(Color.parseColor("#000000"));
                    check_star.setBackgroundResource(R.color.white);
                    check_star.setTextColor(Color.parseColor("#000000"));
                    check_dist.setBackgroundResource(R.color.white);
                    check_dist.setTextColor(Color.parseColor("#000000"));
                    for (int i = 0; i < res_list.size(); i++) {
                        Res_class res = res_list.get(i);
                        if (res.getGenre() == 4)
                            filterRes.add(res);
                    }
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes,(nowMember) getApplication());
                    listView.setAdapter(adapter);
                }
                else{
                    jpn.setBackgroundResource(R.color.white);
                    jpn.setTextColor(Color.parseColor("#000000"));
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list,(nowMember) getApplication());
                    listView.setAdapter(adapter);
                }
            }
        });

        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Res_class> filterRes = new ArrayList<>();
                if(snack.isChecked()){
                    snack.setBackgroundResource(R.drawable.backgrouder);
                    snack.setTextColor(Color.parseColor("#ffffff"));
                    kor.setChecked(false);
                    chn.setChecked(false);
                    usa.setChecked(false);
                    jpn.setChecked(false);
                    check_star.setChecked(false);
                    check_dist.setChecked(false);
                    kor.setBackgroundResource(R.color.white);
                    kor.setTextColor(Color.parseColor("#000000"));
                    chn.setBackgroundResource(R.color.white);
                    chn.setTextColor(Color.parseColor("#000000"));
                    usa.setBackgroundResource(R.color.white);
                    usa.setTextColor(Color.parseColor("#000000"));
                    jpn.setBackgroundResource(R.color.white);
                    jpn.setTextColor(Color.parseColor("#000000"));
                    check_star.setBackgroundResource(R.color.white);
                    check_star.setTextColor(Color.parseColor("#000000"));
                    check_dist.setBackgroundResource(R.color.white);
                    check_dist.setTextColor(Color.parseColor("#000000"));
                    for (int i = 0; i < res_list.size(); i++) {
                        Res_class res = res_list.get(i);
                        if (res.getGenre() == 5)
                            filterRes.add(res);
                    }
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes,(nowMember) getApplication());
                    listView.setAdapter(adapter);
                }
                else{
                    snack.setBackgroundResource(R.color.white);
                    snack.setTextColor(Color.parseColor("#000000"));
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list,(nowMember) getApplication());
                    listView.setAdapter(adapter);
                }
            }
        });


        check_star.setOnClickListener(new View.OnClickListener() {

            ArrayList<Res_class> filterRes = new ArrayList<>();

            @Override
            public void onClick(View v) {
                if (check_star.isChecked()) {
                    filterRes.clear();
                    check_star.setBackgroundResource(R.drawable.backgrouder);
                    check_star.setTextColor(Color.parseColor("#ffffff"));
                    kor.setChecked(false);
                    chn.setChecked(false);
                    usa.setChecked(false);
                    jpn.setChecked(false);
                    snack.setChecked(false);
                    check_dist.setChecked(false);
                    kor.setBackgroundResource(R.color.white);
                    kor.setTextColor(Color.parseColor("#000000"));
                    chn.setBackgroundResource(R.color.white);
                    chn.setTextColor(Color.parseColor("#000000"));
                    usa.setBackgroundResource(R.color.white);
                    usa.setTextColor(Color.parseColor("#000000"));
                    jpn.setBackgroundResource(R.color.white);
                    jpn.setTextColor(Color.parseColor("#000000"));
                    snack.setBackgroundResource(R.color.white);
                    snack.setTextColor(Color.parseColor("#000000"));
                    check_dist.setBackgroundResource(R.color.white);
                    check_dist.setTextColor(Color.parseColor("#000000"));

                    for (int i = 0; i < res_list.size(); i++) {
                        filterRes.add(res_list.get(i));
                    }

                    Collections.sort(filterRes,new starComp());

                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes,(nowMember) getApplication());
                    listView.setAdapter(adapter);
                }
                else{
                    check_star.setBackgroundResource(R.color.white);
                    check_star.setTextColor(Color.parseColor("#000000"));
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list,(nowMember) getApplication());
                    listView.setAdapter(adapter);
                    filterRes.clear();
                }
            }
        });

        check_dist.setOnClickListener(new View.OnClickListener() {
            Res_class arr[] = new Res_class[res_list.size()];
            ArrayList<Res_class> filterRes = new ArrayList<>();

            @Override
            public void onClick(View v) {
                if (check_dist.isChecked()) {
                    filterRes.clear();
                    check_dist.setBackgroundResource(R.drawable.backgrouder);
                    check_dist.setTextColor(Color.parseColor("#ffffff"));
                    kor.setChecked(false);
                    chn.setChecked(false);
                    usa.setChecked(false);
                    jpn.setChecked(false);
                    snack.setChecked(false);
                    check_star.setChecked(false);
                    kor.setBackgroundResource(R.color.white);
                    kor.setTextColor(Color.parseColor("#000000"));
                    chn.setBackgroundResource(R.color.white);
                    chn.setTextColor(Color.parseColor("#000000"));
                    usa.setBackgroundResource(R.color.white);
                    usa.setTextColor(Color.parseColor("#000000"));
                    jpn.setBackgroundResource(R.color.white);
                    jpn.setTextColor(Color.parseColor("#000000"));
                    snack.setBackgroundResource(R.color.white);
                    snack.setTextColor(Color.parseColor("#000000"));
                    check_star.setBackgroundResource(R.color.white);
                    check_star.setTextColor(Color.parseColor("#000000"));

                    for (int i = 0; i < res_list.size(); i++) {
                        filterRes.add(res_list.get(i));
                    }

                    Collections.sort(filterRes,new distComp());



                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, filterRes,(nowMember) getApplication());
                    listView.setAdapter(adapter);

                }
                else{
                    check_dist.setBackgroundResource(R.color.white);
                    check_dist.setTextColor(Color.parseColor("#000000"));
                    Res_Adapter adapter = new Res_Adapter(getApplicationContext(), 0, res_list,((nowMember)getApplication() ));
                    listView.setAdapter(adapter);
                    filterRes.clear();
                }
            }
        });


    }

}
class starComp implements Comparator<Res_class>
{
    @Override
    public int compare(Res_class o1, Res_class o2) {
        if(o1.getStar()>o2.getStar())
            return -1;
        else if(o1.getStar()==o2.getStar())
            return 0;
        else
            return 1;
    }
}

class distComp implements Comparator<Res_class>
{
    @Override
    public int compare(Res_class o1, Res_class o2) {
        if(o1.getLatitude()<o2.getLatitude())
            return -1;
        else if(o1.getLatitude()==o2.getLatitude())
            return 0;
        else
            return 1;
    }
}