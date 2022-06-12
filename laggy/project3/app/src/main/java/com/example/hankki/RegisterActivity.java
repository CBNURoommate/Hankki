package com.example.hankki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    EditText idField;
    EditText pwField;
    EditText nameField;
    Button regbtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        idField=(EditText) findViewById(R.id.regid);
        pwField=(EditText) findViewById(R.id.regpw);
        nameField=(EditText) findViewById(R.id.regname);
        regbtn=(Button) findViewById(R.id.regbtn);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=idField.getText().toString();
                String passwd=pwField.getText().toString();
                String name=nameField.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Toast.makeText(RegisterActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else
                            {
                                Toast.makeText(RegisterActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(RegisterActivity.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(id,passwd,name,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
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
