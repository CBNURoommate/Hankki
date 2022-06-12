package com.example.hankki;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ReplyRequest extends StringRequest {

    final static private String URL="http://3.38.14.46/reply.php";
    private Map<String,String> params;

    public ReplyRequest(String id, Response.Listener <String> listener)
    {
        super(Request.Method.POST,URL,listener,null);
        System.out.println(id);
        params=new HashMap<>();
        params.put("id",id);

    }

    @Nullable
    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
