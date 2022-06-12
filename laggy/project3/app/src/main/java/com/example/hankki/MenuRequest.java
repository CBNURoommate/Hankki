package com.example.hankki;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MenuRequest extends StringRequest {

    final static private String URL="http://3.38.14.46/menulist.php";
    private Map<String,String> params;

    public MenuRequest(String id, Response.Listener <String> listener)
    {
        super(Request.Method.POST,URL,listener,null);

        params=new HashMap<>();
        params.put("id",id);

    }

    @Nullable
    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
