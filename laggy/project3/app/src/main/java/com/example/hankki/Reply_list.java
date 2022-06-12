package com.example.hankki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Reply_list extends AppCompatActivity {
    // 식당 리스트 생성
    public static ArrayList <Reply_class> reply_list = new ArrayList<>();



    ListView listView;
    Button write_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reply_list);

        getSelectedRestaurant();
        reply_list.clear();

        setUpdata();
        setUpList();


        write_btn=(Button)findViewById(R.id.write_btn);
        write_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),writeAcitivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.hold);
            }
        });
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
                    System.out.println(jsonArray.length());
                    for(int i=0;i<jsonArray.length();i++)
                    {

                        Reply_class reply;
                        JSONObject item=jsonArray.getJSONObject(i);
                        reply=new Reply_class(
                                item.getString("id"),
                                item.getString("name"),
                                item.getString("context")
                        );

                        reply_list.add(reply);

                    }


                    setUpList();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };


        ReplyRequest replyRequest = new ReplyRequest(Res_Detail.selectedRestaurant.getRes_id(),responseListener);
        RequestQueue queue = Volley.newRequestQueue(Reply_list.this);
        queue.add(replyRequest);

    }
    //리스트 셋업
    private void setUpList(){
        listView = (ListView) findViewById(R.id.reply_listView);


        //어댑터를 통하여
        com.example.hankki.Reply_adapter adapter = new com.example.hankki.Reply_adapter(getApplicationContext(), 0 , reply_list);
        listView.setAdapter(adapter);

    }


    private void getSelectedRestaurant() {

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        Res_Detail.selectedRestaurant = RestaurantActivity.res_list.get(Integer.valueOf(id));
    }



    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.hold,R.anim.slide_out_right);
    }
}
