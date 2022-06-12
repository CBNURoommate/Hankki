package com.example.hankki;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
                                ((nowMember)getApplication()).setName(jsonResponse.getString("name"));
                                ((nowMember)getApplication()).setId(jsonResponse.getString("id"));
                                ((nowMember)getApplication()).setGenre(jsonResponse.getInt("gerne"));
                                ((nowMember)getApplication()).setSpicy(jsonResponse.getInt("spicy"));
                                ((nowMember)getApplication()).setSalty(jsonResponse.getInt("salty"));
                                ((nowMember)getApplication()).setSalty(jsonResponse.getInt("sea"));
                                ((nowMember)getApplication()).setMush(jsonResponse.getInt("mush"));
                                ((nowMember)getApplication()).setCucum(jsonResponse.getInt("cucum"));
                                ((nowMember)getApplication()).setGosu(jsonResponse.getInt("gosu"));
                                ((nowMember)getApplication()).setGut(jsonResponse.getInt("gut"));
                                System.out.println(((nowMember)getApplication()).getGenre());
                                if(((nowMember) getApplication()).getName()!=null)
                                    PersonalActivity.nowusername.setText(((nowMember) getApplication()).getName());
                                int gerne=((nowMember)getApplication()).getGenre();
                                if(gerne==1)
                                {
                                    PersonalActivity.nowgerne.setText("한식");
                                }
                                else if(gerne==2)
                                {
                                    PersonalActivity.nowgerne.setText("중식");
                                }
                                else if(gerne==3)
                                {
                                    PersonalActivity.nowgerne.setText("양식");
                                }
                                else if(gerne==4)
                                {
                                    PersonalActivity.nowgerne.setText("일식");
                                }
                                else if(gerne==5)
                                {
                                    PersonalActivity.nowgerne.setText("분식");
                                }
                                else;

                                PersonalActivity.nowspicy.setText(((nowMember)getApplication()).getSpicy()+"단계");
                                PersonalActivity.nowsalty.setText(((nowMember)getApplication()).getSalty()+"단계");
                                int sea=((nowMember)getApplication()).getSea();
                                if(sea==1)
                                {
                                    PersonalActivity.nowsea.setText("X");
                                }
                                else if(sea==0)
                                {
                                    PersonalActivity.nowsea.setText("O");
                                }
                                else
                                {
                                    PersonalActivity.nowsea.setText("O");
                                }

                                int mush=((nowMember)getApplication()).getMush();
                                if(mush==1)
                                {
                                    PersonalActivity.nowmush.setText("X");
                                }
                                else if(mush==0)
                                {
                                    PersonalActivity.nowmush.setText("O");
                                }
                                else;


                                int cucum=((nowMember)getApplication()).getCucum();
                                if(cucum==1)
                                {
                                    PersonalActivity.nowcucum.setText("X");
                                }
                                else if(cucum==0)
                                {
                                    PersonalActivity.nowcucum.setText("O");
                                }
                                else;

                                int gosu=((nowMember)getApplication()).getGosu();
                                if(gosu==1)
                                {
                                    PersonalActivity.nowgosu.setText("X");
                                }
                                else if(gosu==0)
                                {
                                    PersonalActivity.nowgosu.setText("O");
                                }
                                else;

                                int gut=((nowMember)getApplication()).getGut();
                                if(gut==1)
                                {
                                    PersonalActivity.nowgut.setText("X");
                                }
                                else if(gut==0)
                                {
                                    PersonalActivity.nowgut.setText("O");
                                }
                                else;


                                finish();
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