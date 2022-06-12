package com.example.hankki;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class LoginRequest extends StringRequest {

    final static private String URL="http://3.38.14.46/login.php";
    private Map<String,String> params;

    public LoginRequest(String id, String passwd, Response.Listener <String> listener)
    {
        super(Method.POST,URL,listener,null);

        params=new HashMap<>();
        params.put("id",id);
        params.put("passwd",passwd);
    }

    @Nullable
    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
