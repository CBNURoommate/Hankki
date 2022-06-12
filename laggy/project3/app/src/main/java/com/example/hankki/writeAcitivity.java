package com.example.hankki;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class writeAcitivity extends AppCompatActivity {


    EditText content;
    Button acc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);
        content=(EditText) findViewById(R.id.content);
        acc=(Button) findViewById(R.id.acc_btn);

        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cont=content.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Toast.makeText(getApplicationContext(), "작성 성공", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "작성 실패", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "작성 오류", Toast.LENGTH_SHORT).show();
                        }
                    }
                };

                writeRequest wRequest = new writeRequest(Res_Detail.selectedRestaurant.getRes_id(),((nowMember)getApplication()).getName(),cont,Integer.toString(Reply_list.reply_list.size()+2),responseListener);
                RequestQueue queue = Volley.newRequestQueue(writeAcitivity.this);
                queue.add(wRequest);
            }
        });



    }
}
