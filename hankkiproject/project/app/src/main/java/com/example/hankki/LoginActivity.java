package com.example.hankki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText idField;
    EditText passwdField;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        idField=(EditText)findViewById(R.id.idField);
        passwdField=(EditText)findViewById(R.id.passwdField);
        login=(Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=idField.getText().toString();
                String passwd=passwdField.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                                loggedMember

                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(id,passwd,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });

    }
}